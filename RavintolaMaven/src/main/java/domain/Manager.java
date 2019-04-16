/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.UsersInFile;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Anttoni
 */
public class Manager extends User {

    private UsersInFile userReader;

    public Manager(String name, String password) throws IOException {
        super(name, password, "manager");
    }

    public void setUserReader(UsersInFile userReader) {
        this.userReader = userReader;
    }

    public UsersInFile getUserReader() {
        return this.userReader;
    }

    public void removeFromMenu(int i) {
        Order poistettava = null;
        for (Order o : super.getMenu()) {
            if (o.getID() == i) {
                poistettava = o;
            }
        }
        super.getMenu().remove(poistettava);
        remakeID(super.getMenu());
    }

    public List<Waiter> getWaiters() {

        return this.userReader.getWaiters();
    }

    public void printMenu() {
        for (Order o : super.orderReader.getOrders()) {
            System.out.println(o.getID() + " = " + o);
        }
    }

    public List<Order> getMenu() {
        return super.orderReader.getOrders();
    }

    public void remakeID(List<Order> l) {
        for (int i = 0; i < l.size(); i++) {
            l.get(i).setID(i + 1);
        }
    }

}
