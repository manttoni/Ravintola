/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Customer {

    private int id;
    private int tableID;
    private List<Order> orders; //lista ordereista joita ei ole vielä maksettu

    /**
     *
     * @param id
     */
    public Customer(int id) {
        this.id = id;
        this.orders = new ArrayList<>();
    }

    /**
     * lisää asiakkaalle tilauksen
     *
     * @param o
     */
    public void addOrder(Order o) {
        this.orders.add(o);
    }

    /**
     *
     * @param id
     */
    public Customer(Integer id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void printOrders() {
        System.out.println("Orders: " + this.orders.size());
        System.out.println(this.orders);
        System.out.println("Total: " + this.totalSum() + "e");
    }

    /**
     * palauttaa asiakkaan tilausten hinnan
     *
     * @return
     */
    public int totalSum() {
        int sum = 0;
        for (Order o : this.orders) {
            sum = sum + o.getPrice();
        }
        return sum;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * asiakas maksaa
     */
    public void checkOut() {
        this.orders = new ArrayList<>();
    }

    public void setOrders(List<Order> ord) {
        this.orders = ord;
    }

    public void removeOrder(Order o) {
        this.orders.remove(o);
    }

}
