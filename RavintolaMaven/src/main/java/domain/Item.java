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

    private int id;
    private final String name;
    private int lkm;

    /**
     *
     * @param id
     * @param name
     * @param lkm
     */
    public Item(int id, String name, int lkm) {
        this.id = id;
        this.name = name;
        this.lkm = lkm;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " | name: " + this.name + " | amount: " + this.lkm;
    }

    public String getName() {
        return this.name;
    }

    public void setLkm(int lkm) {
        this.lkm = lkm;
    }

    public int getLkm() {
        return this.lkm;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

}
