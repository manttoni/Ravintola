/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaUI;

import domain.Chef;
import domain.Item;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class ChefUI {

    private Chef chef;

    /**
     *
     * @param chef
     */
    public ChefUI(Chef chef) {
        this.chef = chef;
    }

    /**
     *
     * @throws IOException
     */
    public void updateInventory() throws IOException {
        List<Item> inventory = this.chef.getInventory();

        System.out.println("Updating inventory list. ");
        System.out.println("Type in correct amount. You can add new items after.");
        System.out.println("-1 is cancel.");
        String valinta;

        for (Item i : inventory) {
            System.out.println(i.getName());
            System.out.println("Amount");
            valinta = leiska.kysy();
            if (valinta.equals("-1")) {
                this.chef = new Chef(this.chef.getUsername(), this.chef.getPassword());
                //loadataan inventory tiedostosta chefin konstruktorissa
                return;
            }
            i.setLkm(Integer.parseInt(valinta));
        }

        valinta = "1";
        while (true) {
            System.out.println("Adding new items.");
            System.out.println("0 is return");
            System.out.println("New item's name");
            valinta = leiska.kysy();
            if (valinta.equals("0")) {
                return;
            }

            String nimi = valinta;
            System.out.println("New amount");
            String lkm = leiska.kysy();
            this.chef.addItem(nimi, Integer.parseInt(lkm));

        }
    }

    /**
     *
     */
    public void printInventory() {
        for (Item i : this.chef.getInventory()) {
            System.out.println(i);
        }
    }
}
