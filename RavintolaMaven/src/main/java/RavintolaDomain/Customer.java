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
    private int tableID;
    private List<Order> orders; //lista ordereista joita ei ole vielä maksettu

    public Customer(int id) {
        this.id = id;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order o){
        this.orders.add(o);
    }
    public Customer(Integer id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
    
    public void printOrders(){
        System.out.println("Orders: " + this.orders.size());
        System.out.println(this.orders);
        System.out.println("Total: " + this.totalSum() + "e");
    }

    public int totalSum(){
        int sum = 0;
        for(Order o : this.orders){
            sum = sum + o.getPrice();
        }
        return sum;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
    
    public void checkOut(){
        this.orders = new ArrayList<>();
    }

}
