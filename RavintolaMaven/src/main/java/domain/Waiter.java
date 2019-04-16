/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import RavintolaUI.leiska;
import dao.OrdersInFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class Waiter extends User {

    public Waiter(String name, String password) throws IOException {
        super(name, password, "waiter");
    }

    public static List<Order> addOrder(Customer customer) throws IOException {
        List<Order> palautus = new ArrayList<>();
        while (true) {
            leiska.viiva();
            OrdersInFile orderReader = new OrdersInFile();
            orderReader.readOrdersFromFile();
            List<Order> orders = orderReader.getOrders();
            for (Order o : orders) {
                System.out.println(o.getID() + " = " + o);
            }
            System.out.println("0 = back");
            String valinta = leiska.kysy();
            if (valinta.equals("0")) {
                break;
            }
            for (Order o : orders) {
                if (o.getID() == Integer.parseInt(valinta)) {
                    customer.addOrder(o);
                    System.out.println("Order added: " + o);
                    palautus.add(o);
                }
            }

        }
        return palautus;
    }

    public static Customer editCustomer(Table table) throws IOException {

        Customer haamu;

        Scanner s = new Scanner(System.in);
        String valinta;

        System.out.print("Select customer by id: ");
        valinta = s.nextLine();
        Customer c = table.getCustomerWithID(Integer.parseInt(valinta));
        haamu = c;
        haamu.checkOut();
        leiska.viiva();

        c.printOrders();

        leiska.viiva();
        System.out.println("1 = check out");
        System.out.println("2 = add order");
        leiska.viiva();

        System.out.print("Select: ");
        valinta = s.nextLine();
        leiska.viiva();
        if (valinta.equals("1")) {
            table.checkOutCustomer(c);
        } else if (valinta.equals("2")) {
            haamu.setOrders(addOrder(c));
        }

        return haamu;

    }

    public static void editTable(Table table) throws IOException {

        List<Customer> uudetTilaukset = new ArrayList<>();
        List<Customer> save = new ArrayList<>();

        for (Customer c : table.getCustomers()) {
            Customer haamu = new Customer(c.getID());
            for (Order o : c.getOrders()) {
                haamu.addOrder(o);
            }
            save.add(haamu);
        }

        while (true) {
            System.out.println(table);
            table.printCustomers();
            leiska.viiva();
            System.out.println("0 = cancel");
            System.out.println("1 = add customer");
            System.out.println("2 = edit customer");
            System.out.println("3 = confirm");
            String valinta = leiska.kysy();

            if (valinta.equals("0")) {
                System.out.println("Orders cancelled");
                table.setCustomers(save); //palataan takaisin tilanteeseen, joka oli tämän metodin alussa
                return;
            }

            if (valinta.equals("1")) {
                table.addCustomer();
            } else if (valinta.equals("2")) {
                uudetTilaukset.add(editCustomer(table));
                //aina kun editoidaan pöydän asiakkaita, pidetään kirjaa uusista tilauksista, jotta ne voi lopuksi hyväksyä tai perua
            } else if (valinta.equals("3")) {
                System.out.println("New bong sent to kitchen:");
                for (Customer c : uudetTilaukset) {
                    for (Order o : c.getOrders()) {
                        System.out.println(o);
                    }
                }

                return;
            }
        }
    }

    public void manageTables() throws Exception {
        while (true) {

            printTables();

            System.out.println("0 = back");
            String valinta = leiska.kysy();
            if (valinta.equals("0")) {
                break;
            }
            int tableID = Integer.parseInt(valinta);
            Table table = null;

            for (Table t : getTables()) { //valitaan pöytä
                if (tableID == t.getID()) {
                    table = t;
                }
            }

            System.out.println("Table: " + valinta);
            System.out.println("Customers: " + table.getCustomers().size());
            leiska.viiva();
            table.printCustomers();
            leiska.viiva();
            System.out.println("0 = back");
            System.out.println("1 = edit selected table (n. " + valinta + ")");
            System.out.println("2 = checkout table");

            valinta = leiska.kysy();

            if (valinta.equals("1")) {
                editTable(table);
            }
            if (valinta.equals("2")) {
                table.checkOut();
            }
            if (valinta.equals("0")) {
                break;
            }
        }
    }

    public void printTables() {
        for (Table t : this.tableReader.getTables()) {
            System.out.println(t);
        }
    }

}
