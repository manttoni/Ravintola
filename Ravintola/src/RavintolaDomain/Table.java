/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDomain;

import RavintolaDao.CustomersInFile;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Table {

    private final int number;
    private boolean reserved;
    private List<Customer> customers;

    public Table(int number, boolean reserved, List<Integer> idList) throws IOException {

        CustomersInFile customersInFile = new CustomersInFile("customerlist.txt");

        this.number = number;
        this.reserved = reserved;
        this.customers = customersInFile.getCustomers(idList);
    }

    @Override
    public String toString() {

        String palautus = "Table n. " + number + " is reserved: " + reserved;

        if (reserved) {
            return palautus + " number of customers: " + customers.size();
        }

        return palautus;

    }

    public int getID() {
        return this.number;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void printCustomers() {
        for (int i = 0; i < this.customers.size(); i++) {
            int n = i + 1;
            System.out.println("***\nCustomer n. " + n);
            System.out.println(this.customers.get(i));
        }
    }

}
