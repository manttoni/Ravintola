/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import RavintolaUI.leiska;
import dao.UsersInFile;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class Manager extends User {

    private List<Waiter> waiters;

    public Manager(String name, String password) throws IOException {
        super(name, password, "manager");

    }

    public void manageWaiters() throws IOException {

        UsersInFile userReader = new UsersInFile();
        userReader.readUsersFromFile();

        while (true) {
            this.waiters = userReader.getWaiters();
            System.out.println("List of waiter users");
            for (Waiter w : waiters) {
                System.out.println("username = " + w.getUsername());
            }

            System.out.println("0 = back");
            System.out.println("Type username from list to remove user. \nType new username to add user");
            String valinta = leiska.kysy();

            if (valinta.equals("0")) {
                break;
            } else {
                userReader.removeOrAdd(valinta);
            }
        }
    }

    public void printMenu() {
        for (Order o : super.orderReader.getOrders()) {
            System.out.println(o.getID() + " = " + o);
        }
    }

    public void removeOrder(int id) {
        List<Order> orders = this.orderReader.getOrders();
        Order poistettava = null;
        for (Order o : orders) {
            if (o.getID() == id) {
                poistettava = o;
            }
        }
        orders.remove(poistettava);
        remakeID(orders);
    }

    public void remakeID(List<Order> l) {
        for (int i = 0; i < l.size(); i++) {
            l.get(i).setID(i + 1);
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
                    printMenu();
                    leiska.viiva();
                    System.out.println("0 = back");
                    System.out.println("x = remove");
                    int i = super.orderReader.getOrders().size() + 1;
                    System.out.println(i + " = add");
                    valinta = leiska.kysy();
                    if (valinta.equals("0")) {
                        break;
                    } else if (valinta.equals("" + i)) {
                        Scanner s = new Scanner(System.in);
                        System.out.print("New menu item's name: ");
                        String orderName = s.nextLine();
                        System.out.print("New menu item's price: ");
                        int price = Integer.parseInt(s.nextLine());
                        addOrder(i, orderName, price);
                    } else {
                        removeOrder(Integer.parseInt(valinta));
                    }
                }
            }
        }
    }

}
