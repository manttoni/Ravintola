/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaUI;

import domain.Customer;
import domain.Order;
import domain.Table;
import domain.Waiter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class WaiterUI {

    private Waiter waiter;

    public WaiterUI(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<Order> addOrder(Customer customer) throws IOException {
        //lisää orderin ja palauttaa listan tehdyistä muutoksista mahdollista peruutusta varten
        List<Order> palautus = new ArrayList<>();
        while (true) {
            this.waiter.printMenu();
            System.out.println("0 = back");
            String valinta = leiska.kysy();
            if (valinta.equals("0")) {
                break;
            }

            int orderID = Integer.parseInt(valinta);

            palautus.add(this.waiter.addOrderToCustomer(customer, orderID));

        }
        return palautus;
    }

    public List<Order> editCustomer(Table table) throws IOException {

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
        valinta = leiska.kysy();
        if (valinta.equals("1")) {
            table.checkOutCustomer(c);
        } else if (valinta.equals("2")) {
            haamu.setOrders(addOrder(c));
        }

        return haamu.getOrders();

    }

    public void editTable(Table table) throws IOException {

        List<Order> uudetTilaukset = new ArrayList<>();
        List<Customer> save = waiter.getCustomersCopy(table);

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
                uudetTilaukset.addAll(editCustomer(table));
                //aina kun editoidaan pöydän asiakkaita, pidetään kirjaa uusista tilauksista, jotta ne voi lopuksi hyväksyä tai perua
            } else if (valinta.equals("3")) {
                waiter.sendKitchenBong(uudetTilaukset);

                return;
            }
        }
    }

    public void manageTables() throws Exception {
        while (true) {

            waiter.printTables();

            System.out.println("0 = back");
            String valinta = leiska.kysy();
            if (valinta.equals("0")) {
                break;
            }
            int tableID = Integer.parseInt(valinta);
            Table table = null;

            for (Table t : waiter.getTables()) { //valitaan pöytä
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
}
