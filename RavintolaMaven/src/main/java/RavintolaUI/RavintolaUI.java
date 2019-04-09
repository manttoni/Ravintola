/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaUI;

import RavintolaDao.OrdersInFile;
import RavintolaDao.TablesInFile;
import RavintolaDao.UsersInFile;
import RavintolaDomain.Order;
import RavintolaDomain.Table;
import RavintolaDomain.User;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class RavintolaUI {

    /**
     *
     * @throws java.io.IOException
     */
    private static Scanner sc = new Scanner(System.in);

    public static void login() throws Exception {

        UsersInFile users = new UsersInFile("src/main/java/RavintolaDao/txt/userlist.txt");

        //users.printUsers();
        System.out.println("***");
        System.out.print("Username: ");

        String username = sc.nextLine();

        System.out.print("Password: ");

        String password = sc.nextLine();

        User user = new User(username, password);

        User reference = users.getUser(user);

        if (users.isUser(user) && reference.getStatus().equals("waiter")) {
            welcomeWaiter(reference);
        } else if (users.isUser(user) && reference.getStatus().equals("manager")) {
            welcomeManager(reference);
        } else {
            System.out.println("Wrong username or password");
            return;
        }

    }

    public static void welcomeWaiter(User user) throws Exception {
        while (true) {
            System.out.println("***");
            System.out.println("Welcome " + user.getUsername());
            System.out.println("1 = log out");
            if (user.getStatus().equals("waiter")) {
                System.out.println("2 = manage tables");
            }
            System.out.println("***");
            String v = sc.nextLine();
            if (v.equals("1")) {
                return;
            } else if (v.equals("2")) {
                manageTables(user);
            }
        }
    }

    public static void manageTables(User user) throws Exception {

        TablesInFile tables = new TablesInFile("src/main/java/RavintolaDao/txt/tablelist.txt");

        System.out.println("***");

        tables.printTables();

        System.out.println("***");
        System.out.print("Select table: ");

        String v = sc.nextLine();
        int tableID = Integer.parseInt(v);
        Table table = tables.getTable(tableID);

        System.out.println("***");
        System.out.println("---");
        System.out.println("Table: " + v);
        System.out.println("Customers: " + table.getCustomers().size());
        table.printCustomers();
        System.out.println("---");
        return;

    }

    public static void welcomeManager(User user) throws IOException {
        while (true) {
            System.out.println("***");
            System.out.println("Welcome " + user.getUsername());
            System.out.println("1 = log out");
            System.out.println("2 = show menu");
            System.out.println("***");
            String v = sc.nextLine();
            if (v.equals("1")) {
                return;
            } else if (v.equals("2")) {
                manageMenu(user);
            }
        }
    }

    public static void manageMenu(User user) throws IOException {
        OrdersInFile orders = new OrdersInFile("orderlist.txt");
        List<Order> menu = orders.getOrders();

        System.out.println("***");
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

}
