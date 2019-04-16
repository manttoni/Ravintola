/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class InventoryInFile {

    private final String file = "src/main/java/dao/txt/inventory.txt";
    private final List<Item> inventory;

    public InventoryInFile() {
        this.inventory = new ArrayList<>();
    }

    public void readItemsFromFile() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file));

        while (reader.hasNextLine()) {
            String[] rivi = reader.nextLine().split(";");
            int id = Integer.parseInt(rivi[0]);
            String name = rivi[1];
            int lkm = Integer.parseInt(rivi[2]);
            this.inventory.add(new Item(id, name, lkm));
        }
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

}
