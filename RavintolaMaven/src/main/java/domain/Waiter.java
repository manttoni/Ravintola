/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Waiter extends User {

    private final List<Order> menu;

    public Waiter(String name, String password) throws IOException {
        super(name, password, "waiter");
        menu = super.orderReader.getOrders();
    }

    /**
     * Luo kopion asiakkaista, johon voidaan myöhemmin palata
     *
     * @param table
     * @return
     */
    public List<Customer> getCustomersCopy(Table table) {
        List<Customer> save = new ArrayList<>();
        for (Customer c : table.getCustomers()) {
            Customer haamu = new Customer(c.getID());
            for (Order o : c.getOrders()) {
                haamu.addOrder(o);
            }
            save.add(haamu);
        }
        return save;
    }

    /**
     *
     */
    public void printMenu() {
        for (Order o : menu) {
            System.out.println(o.getID() + " = " + o);
        }
    }

    public Order addOrderToCustomer(Customer c, int orderID) {

        for (Order o : menu) {
            if (o.getID() == orderID) {
                c.addOrder(o);
                System.out.println("Order added: " + o);
                return o;
            }
        }
        System.out.println("Nothing added");
        return null;
    }

    /*
     *"lähettää" keittiöön tilauksen
     */
    public void sendKitchenBong(List<Order> newOrders) {
        System.out.println("Bong sent to kitchen: ");
        for (Order o : newOrders) {
            System.out.println(o);
        }
    }

    public void printTables() {
        for (Table t : this.tableReader.getTables()) {
            System.out.println(t);
        }
    }

}
