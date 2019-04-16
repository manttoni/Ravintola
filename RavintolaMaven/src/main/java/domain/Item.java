/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Anttoni
 */
public class Item {

    private final int id;
    private final String name;
    private final int lkm;

    public Item(int id, String name, int lkm) {
        this.id = id;
        this.name = name;
        this.lkm = lkm;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " | name: " + this.name + " | amount: " + this.lkm;
    }

}
