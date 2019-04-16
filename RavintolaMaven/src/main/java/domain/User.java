/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.OrdersInFile;
import dao.TablesInFile;
import dao.UsersInFile;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class User {

    private final String name;
    private String password;
    private String status = "?";
    protected final TablesInFile tableReader;
    protected final OrdersInFile orderReader;
    protected final UsersInFile userReader;

    public User(String name, String password, String status) throws IOException {
        this.name = name;
        this.password = password;
        this.status = status;

        this.tableReader = new TablesInFile();
        this.tableReader.readTablesFromFile();

        this.orderReader = new OrdersInFile();
        this.orderReader.readOrdersFromFile();

        this.userReader = new UsersInFile();
    }

    public void changePassword() throws IOException {
        System.out.print("New password: ");
        Scanner s = new Scanner(System.in);
        String newPassword = s.nextLine();
        this.userReader.readUsersFromFile();
        for (User u : this.userReader.getUsers()) {
            if (u.getUsername().equals(this.name)) {
                u.setPassword(newPassword);
            }
        }
        userReader.writeUsersToFile();
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void saveAll() throws IOException {
        saveTables();
        saveOrders();
    }

    public void saveTables() throws IOException {
        this.tableReader.writeTablesToFile();
        System.out.println("Tables saved");
    }

    public List<Table> getTables() {
        return this.tableReader.getTables();
    }

    public List<Order> getMenu() {
        return this.orderReader.getOrders();
    }

    @Override
    public String toString() {
        return "username: " + this.name + " | status: " + this.status;
    }

    public String getUsername() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {

        return this.status;

    }

    public void saveOrders() throws IOException {

        this.orderReader.writeOrdersToFile();
        System.out.println("Menu saved");
    }

}
