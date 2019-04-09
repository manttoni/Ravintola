/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDomain;

/**
 *
 * @author Anttoni
 */
public class Order {

    private final int id;
    private final String name;
    private final int price;

    public Order(int id, String name, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " * " + this.price + "e";
    }

    public int getID() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

}
