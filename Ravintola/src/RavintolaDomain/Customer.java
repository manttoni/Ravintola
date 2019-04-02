/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDomain;

import RavintolaDao.OrdersInFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Customer {

    private final int id;
    private List<Order> orders;

    public Customer(int id, List<Integer> idList) throws IOException {

        OrdersInFile orderReader = new OrdersInFile("orderlist.txt");

        this.id = id;
        this.orders = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            for (int j = 0; j < orderReader.getOrders().size(); j++) {
                if(idList.get(i) == orderReader.getOrders().get(j).getID()){
                    orders.add(orderReader.getOrders().get(j));
                }
            }
        }
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        String palautus = "";
        int yht = 0;
        System.out.print("Orders: " + this.orders.size());
        for (int i = 0; i < this.orders.size(); i++) {
            Order o = this.orders.get(i);
            palautus = palautus +  "\n - " + o.toString();
            yht = yht + o.getPrice();
        }
        palautus = palautus + "\nTotal: " + yht + "€";
        return palautus;
    }

}
