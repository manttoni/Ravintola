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

    public Chef(String name, String password) throws IOException {
        super(name, password, "chef");
        InventoryInFile inventoryReader = new InventoryInFile();
        inventoryReader.readItemsFromFile();
        inventory = inventoryReader.getInventory();
    }

    public void printInventory() {
        for (Item i : this.inventory) {
            System.out.println(i);
        }
    }

}
