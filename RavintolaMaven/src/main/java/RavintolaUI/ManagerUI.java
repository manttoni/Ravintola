/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaUI;

import domain.Manager;
import domain.Order;
import domain.Waiter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class ManagerUI {

    private Manager manager;

    public ManagerUI(Manager manager) {
        this.manager = manager;
    }

    public void manageWaiters() throws IOException {
        ;
        while (true) {
            System.out.println("List of waiter users: ");
            for (Waiter w : manager.getWaiters()) {
                System.out.println("username = " + w.getUsername());
            }

            leiska.viiva();

            System.out.println("0 = back");
            System.out.println("Type username from list to remove user. \nType new username to add user");
            String valinta = leiska.kysy();

            if (valinta.equals("0")) {
                break;
            } else {
                manager.getUserReader().removeOrAdd(valinta);
            }
        }
    }

    public void manageMenu() throws IOException {
        while (true) {
            System.out.println("0 = back");
            System.out.println("1 = print menu");
            String valinta = leiska.kysy();
            if (valinta.equals("0")) {
                break;
            }
            if (valinta.equals("1")) {
                while (true) {
                    this.manager.printMenu();
                    leiska.viiva();
                    System.out.println("0 = back");
                    System.out.println("x = remove");
                    int i = manager.getMenu().size() + 1;
                    System.out.println(i + " = add");
                    valinta = leiska.kysy();
                    if (valinta.equals("0")) {
                        break;
                    } else if (valinta.equals("" + i)) {
                        addToMenu(i);
                    } else {
                        manager.removeFromMenu(Integer.parseInt(valinta));
                    }
                }
            }
        }
    }

    public void addToMenu(int i) {
        Scanner s = new Scanner(System.in);
        System.out.print("New menu item's name: ");
        String orderName = s.nextLine();
        System.out.print("New menu item's price: ");
        int price = Integer.parseInt(s.nextLine());
        manager.getMenu().add(new Order(i, orderName, price));
        leiska.viiva();
    }

}
