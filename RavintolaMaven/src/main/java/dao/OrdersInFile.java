/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;
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
public class OrdersInFile {

    private List<Order> orders;
    private final String file = "src/main/java/dao/txt/orderlist.txt";

    public OrdersInFile() throws IOException {
        orders = new ArrayList<>();

    }

    public void readOrdersFromFile() throws IOException {
        Scanner reader = new Scanner(new File(file));

        while (reader.hasNextLine()) {
            String[] parts = reader.nextLine().split(";");
            Order o = new Order(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));

            orders.add(o);
        }

    }

    public void writeOrdersToFile() throws IOException {
        FileWriter writer = new FileWriter(this.file);
        for (Order o : this.orders) {
            String rivi = o.getID() + ";" + o.getName() + ";" + o.getPrice();
            writer.write(rivi + "\n");
        }
        writer.close();
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void addToOrders(Order o) {
        this.orders.add(o);
    }
}
