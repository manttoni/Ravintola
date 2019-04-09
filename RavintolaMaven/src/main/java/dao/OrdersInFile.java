/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDao;

import RavintolaDomain.Order;
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
    private final String file = "src/main/java/RavintolaDao/txt/orderlist.txt";

    public OrdersInFile() throws IOException {
        orders = new ArrayList<>();

    }

    public void readOrdersFromFile() throws IOException {
        try {
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Order o = new Order(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));

                orders.add(o);
            }
        } catch (Exception e) {

            System.out.println("File not found");
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    public List<Order> getOrders() {
        return this.orders;
    }

}
