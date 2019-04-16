/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import RavintolaUI.leiska;
import domain.Chef;
import domain.Manager;
import domain.User;
import domain.Waiter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class UsersInFile {

    private List<User> users;
    private final String file = "src/main/java/dao/txt/userlist.txt";

    public UsersInFile() {
        users = new ArrayList<>();

    }

    public void writeUsersToFile() throws IOException {
        FileWriter writer = new FileWriter(this.file);

        for (User u : this.users) {
            String rivi = u.getUsername() + ";" + u.getPassword() + ";" + u.getStatus();
            writer.write(rivi + "\n");
        }
        writer.close();
        System.out.println("Users saved");
    }

    public void readUsersFromFile() throws IOException {

        Scanner reader = new Scanner(new File(file));

        while (reader.hasNextLine()) {
            User u = null;
            String[] parts = reader.nextLine().split(";");
            if (parts[2].equals("waiter")) {
                u = new Waiter(parts[0], parts[1]);
            } else if (parts[2].equals("manager")) {
                u = new Manager(parts[0], parts[1]);
            } else if (parts[0].equals("chef")) {
                u = new Chef(parts[1], parts[2]);
            }

            users.add(u);
        }

    }

    public void removeOrAdd(String username) throws IOException {

        if (this.isUser(username)) {
            removeUser(this.getUser(username));
            return;
        }
        addUser(new Waiter(username, "1234"));
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void addUser(Waiter waiter) throws IOException {
        this.users.add(waiter);
        System.out.println(waiter + " added. Temporary password is 1234.");
        writeUsersToFile();
    }

    public boolean isUser(String username) {

        for (User u : this.users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public User getUser(String username) {
        User u;

        for (int i = 0; i < users.size(); i++) {
            u = users.get(i);
            if (u.getUsername().equals(username)) {
                return u;
            }
        }

        return null;
    }

    public List<Waiter> getWaiters() {
        List<Waiter> waiters = new ArrayList<>();

        for (User u : this.users) {
            if (u.getStatus().equals("waiter")) {
                waiters.add((Waiter) u);
            }
        }

        return waiters;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void printWaiters() throws IOException {
        for (User u : this.users) {
            if (u.getStatus().equals("waiter")) {
                System.out.println(u);
            }
        }
        leiska.viiva();
    }

}
