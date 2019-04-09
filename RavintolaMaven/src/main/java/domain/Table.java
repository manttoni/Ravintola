/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import RavintolaUI.leiska;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Table {

    private final int id;
    private List<Customer> customers;

    public Table(int id) {
        this.id = id;
        this.customers = new ArrayList<>();
    }

    @Override
    public String toString() {

        return "Table n. " + id + "\nNumber of customers: " + customers.size();

    }

    public void checkOut() {
        this.customers = new ArrayList<>();
    }

    public void checkOutCustomer(Customer customerPaid) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getID() == customerPaid.getID()) {
                this.customers.remove(i);
            }
        }
    }

    public Customer getCustomerWithID(int id) {
        for (Customer c : this.customers) {
            if (c.getID() == id) {
                return c;
            }
        }
        return null;
    }

    public int getID() {
        return this.id;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void printCustomers() {
        for (int i = 0; i < this.customers.size(); i++) {
            int n = i + 1;
            leiska.viiva();
            System.out.println("Customer n. " + n + "(id: " + this.customers.get(i).getID() + ")");
            this.customers.get(i).printOrders();
        }
    }

    public int getNewCustomerID() {
        int idOsaKaks = 1;
        List<Integer> notFreeIDs = new ArrayList<>();

        for (Customer c : this.customers) {
            notFreeIDs.add(c.getID());
        }

        while (notFreeIDs.contains(Integer.parseInt("" + this.id + idOsaKaks))) {
            idOsaKaks++;
        }
        return Integer.parseInt("" + this.id + idOsaKaks);
    }

    public void addCustomer(Customer customer) {

        this.customers.add(customer);
    }

}
