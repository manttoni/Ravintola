package RavintolaUI;

import dao.OrdersInFile;
import dao.TablesInFile;
import dao.UsersInFile;
import domain.Customer;
import domain.Order;
import domain.Table;
import domain.User;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RavintolaUI {

    public static void login() throws Exception {

        Scanner s = new Scanner(System.in);

        UsersInFile users = new UsersInFile();
        users.readUsersFromFile();

        leiska.viiva();
        System.out.print("Username: ");

        String username = s.nextLine();

        System.out.print("Password: ");

        String password = s.nextLine();

        leiska.viiva();

        User user = new User(username, password);

        User reference = users.getUser(user);

        if (users.isUser(reference) && reference.getStatus().equals("waiter")) {
            welcomeWaiter(reference);
        } else if (users.isUser(user) && reference.getStatus().equals("manager")) {
            welcomeManager(reference);
        } else {
            System.out.println("Wrong username or password");
        }

    }

    public static void save(List<Table> tables) throws IOException {
        TablesInFile tableWriter = new TablesInFile();
        tableWriter.writeTablesToFile(tables);
    }

    public static void welcomeWaiter(User user) throws Exception {

        Scanner s = new Scanner(System.in);

        TablesInFile tableReader = new TablesInFile();
        tableReader.readTablesFromFile();
        List<Table> tables = tableReader.getTables();

        while (true) {

            System.out.println("Welcome " + user.getUsername());

            System.out.println("1 = manage tables");
            System.out.println("0 = log out and save");
            leiska.viiva();
            String v = s.nextLine();
            if (v.equals("0")) {
                save(tables);
                break;
            } else if (v.equals("1")) {
                manageTables(tables);

            }
        }
    }

    public static void manageTables(List<Table> tables) throws Exception {
        while (true) {
            Scanner s = new Scanner(System.in);

            leiska.viiva();

            for (Table t : tables) {
                System.out.println(t);
                leiska.viiva();
            }
            System.out.println("0 = back");

            leiska.viiva();
            System.out.print("Select: ");

            String v = s.nextLine();
            leiska.viiva();
            if (v.equals("0")) {
                break;
            }
            int tableID = Integer.parseInt(v);
            Table table = null;

            for (Table t : tables) {
                if (tableID == t.getID()) {
                    table = t;
                }
            }

            System.out.println("Table: " + v);
            System.out.println("Customers: " + table.getCustomers().size());
            leiska.viiva();
            table.printCustomers();
            leiska.viiva();

            System.out.println("1 = edit selected table (n. " + v + ")");
            System.out.println("2 = checkout table");
            System.out.println("0 = back");

            leiska.viiva();

            v = s.nextLine();

            if (v.equals("1")) {
                editTable(table);

            }
            if (v.equals("2")) {
                table.checkOut();
            }
            if (v.equals("0")) {
                break;
            }
        }
    }

    public static void editTable(Table table) throws IOException {

        while (true) {
            System.out.println(table);
            table.printCustomers();
            leiska.viiva();
            System.out.println("1 = add customer");
            System.out.println("2 = edit customer");
            System.out.println("0 = back");
            leiska.viiva();
            System.out.print("Selection: ");
            Scanner s = new Scanner(System.in);
            String v = s.nextLine();
            leiska.viiva();

            if (v.equals("1")) {
                addCustomer(table);
            } else if (v.equals("2")) {
                editCustomer(table);
            } else if (v.equals("0")) {
                break;
            }
        }
    }

    public static void addCustomer(Table table) {
        table.addCustomer(new Customer(table.getNewCustomerID()));
    }

    public static void editCustomer(Table table) throws IOException {

        Scanner s = new Scanner(System.in);
        String valinta;

        System.out.print("Select customer by id: ");
        valinta = s.nextLine();
        Customer c = table.getCustomerWithID(Integer.parseInt(valinta));
        leiska.viiva();

        c.printOrders();

        leiska.viiva();
        System.out.println("1 = check out");
        System.out.println("2 = add order");
        leiska.viiva();

        System.out.print("Select: ");
        valinta = s.nextLine();
        leiska.viiva();
        if (valinta.equals("1")) {
            //asiakas maksaa kaiken
            table.checkOutCustomer(c);
        } else if (valinta.equals("2")) {
            addOrder(c);

        }
    }

    public static void addOrder(Customer customer) throws IOException {
        while (true) {
            leiska.viiva();
            OrdersInFile orderReader = new OrdersInFile();
            orderReader.readOrdersFromFile();
            List<Order> orders = orderReader.getOrders();
            for (Order o : orders) {
                System.out.println(o.getID() + " = " + o);
            }
            System.out.println("0 = back");
            leiska.viiva();
            System.out.print("Select: ");

            Scanner s = new Scanner(System.in);
            String valinta = s.nextLine();
            leiska.viiva();
            if (valinta.equals("0")) {
                break;
            }
            for (Order o : orders) {
                if (o.getID() == Integer.parseInt(valinta)) {
                    customer.addOrder(o);
                    System.out.println("Order added: " + o);
                }
            }

        }
    }

    public static void welcomeManager(User user) throws IOException {

        Scanner s = new Scanner(System.in);

        while (true) {
            leiska.viiva();
            System.out.println("Welcome " + user.getUsername());
            System.out.println("0 = log out");
            System.out.println("2 = show menu");
            leiska.viiva();
            String v = s.nextLine();
            if (v.equals("0")) {
                break;
            } else if (v.equals("2")) {
                manageMenu(user);
            }
        }
    }

    public static void manageMenu(User user) throws IOException {
        OrdersInFile orders = new OrdersInFile();
        orders.readOrdersFromFile();
        List<Order> menu = orders.getOrders();

        leiska.viiva();
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

}
