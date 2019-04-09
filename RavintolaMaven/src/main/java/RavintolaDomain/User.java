/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDomain;

/**
 *
 * @author Anttoni
 */
public class User {

    private String name;
    private String password;
    private String status = "?";

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    @Override
    public String toString() {

        return "User{" + "name=" + name + ", password=" + password + ", status=" + status + '}';
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


}
