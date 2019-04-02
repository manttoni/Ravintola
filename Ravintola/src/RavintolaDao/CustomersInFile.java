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
public class CustomersInFile {

    private List<Customer> customers;
    private String file;

    public CustomersInFile(String file) throws IOException {
        customers = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                List<Integer> idList = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    idList.add(Integer.parseInt(parts[i]));
                }
                Customer c = new Customer(id, idList);

                customers.add(c);
            }
        } catch (Exception e) {

            System.out.println("File not found");
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    public List<Customer> getCustomers(List<Integer> idList) {
        List<Customer> lista = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            for (int j = 0; j < customers.size(); j++) {
                Customer c = new Customer(idList.get(i));
                if (c.getID() == customers.get(j).getID()) {
                    lista.add(customers.get(i));
                }
            }
        }
        return lista;
    }
}
