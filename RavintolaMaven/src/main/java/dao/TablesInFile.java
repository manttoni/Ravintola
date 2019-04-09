/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDao;

import RavintolaDomain.Customer;
import RavintolaDomain.Order;
import RavintolaDomain.Table;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class TablesInFile {

    private List<Table> tables;
    private final String file = "src/main/java/RavintolaDao/txt/tablelist.txt";

    public TablesInFile() {

        this.tables = new ArrayList<>();

    }

    public void writeTablesToFile(List<Table> tables) throws IOException {

        FileWriter writer = new FileWriter(this.file);
        for (Table t : tables) {
            writer.write("tableID = " + t.getID() + "\n");
            if (!t.getCustomers().isEmpty()) {
                for (Customer c : t.getCustomers()) {
                    writer.write("customerID = " + c.getID() + "\n");
                    if (!c.getOrders().isEmpty()) {
                        for (Order o : c.getOrders()) {
                            writer.write("orderID = " + o.getID() + "\n");
                        }
                    }
                    writer.write("endCustomer\n");
                }
            }
            writer.write("endTable\n");
        }
        writer.write("endFile");
        writer.close();
    }

    public void readTablesFromFile() throws IOException {

        OrdersInFile orderReader = new OrdersInFile();
        orderReader.readOrdersFromFile();
        List<Order> orders = orderReader.getOrders();

        try {
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {

                String tableRivi = reader.nextLine();

                if (tableRivi.equals("endFile")) { //ei olekkaan uusi table
                    break;
                }
                String[] tablePalat = tableRivi.split(" = ");
                Table t = new Table(Integer.parseInt(tablePalat[1]));

                while (true) {

                    String customerRivi = reader.nextLine();
                    if (customerRivi.equals("endTable")) { //ei olekkaan uusi customer
                        this.tables.add(t); //lisätään pöytä
                        break;
                    }
                    String[] customerPalat = customerRivi.split(" = ");
                    Customer c = new Customer(Integer.parseInt(customerPalat[1]));

                    while (true) {

                        String orderRivi = reader.nextLine();
                        if (orderRivi.equals("endCustomer")) {
                            t.addCustomer(c);
                            break;
                        }
                        String[] orderPalat = orderRivi.split(" = ");
                        int orderID = Integer.parseInt(orderPalat[1]);

                        for (Order o : orders) {

                            if (o.getID() == orderID) {
                                c.addOrder(o);
                            }
                        }
                    }

                }
            }
        } catch (IOException e) {

            System.out.println("File not found");
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    public Table getTable(int id) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getID() == id) {
                return tables.get(i);
            }
        }
        return null;
    }

    public List<Table> getTables() {
        return this.tables;
    }

}
