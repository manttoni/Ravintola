/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.InventoryInFile;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Chef extends User {

    private List<Item> inventory;
    private InventoryInFile inFile;

    /**
     *
     * @param name
     * @param password
     * @throws IOException
     */
    public Chef(String name, String password) throws IOException {
        super(name, password, "chef");
        inFile = new InventoryInFile();
        inFile.readItemsFromFile();
        this.inventory = inFile.getInventory();
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void addItem(String name, int lkm) throws IOException {
        Item i = new Item(getNewItemID(), name, lkm);
        this.inventory.add(i);
        this.inFile.writeInventoryToFile();

    }

    /**
     * palauttaa uuden IDn lisättävälle itemille
     *
     * @return
     */
    public int getNewItemID() {
        remakeID();
        return this.inventory.size() + 1;
    }

    /**
     * järjestää itemit id:n mukaan
     */
    public void remakeID() {
        for (int i = 1; i <= this.inventory.size(); i++) {
            this.inventory.get(i - 1).setID(i);
        }
    }

}
