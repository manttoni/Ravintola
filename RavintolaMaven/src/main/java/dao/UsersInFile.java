/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
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

    public void readUsersFromFile() throws IOException {
        try {
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], parts[1], parts[2]);

                users.add(u);
            }
        } catch (Exception e) {

            System.out.println("File not found");
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    public boolean isUser(User user) {

        User u;

        for (int i = 0; i < users.size(); i++) {
            u = users.get(i);
            if (u.getUsername().equals(user.getUsername())) {
                return u.getPassword().equals(user.getPassword());
            }
        }

        return false;
    }

    public void printUsers() {
        System.out.println("Existing users and passwords and status " + users.size());
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    public User getUser(User user) {
        User u;

        for (int i = 0; i < users.size(); i++) {
            u = users.get(i);
            if (u.getUsername().equals(user.getUsername())) {
                return u;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return this.users;
    }

}
