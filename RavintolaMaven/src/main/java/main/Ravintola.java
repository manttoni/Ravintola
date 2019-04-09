package main;

import RavintolaUI.RavintolaUI;
import RavintolaUI.leiska;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class Ravintola {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        while (true) {

            leiska.viiva();
            System.out.println("1 = quit");
            System.out.println("2 = log in");
            leiska.viiva();
            if (s.nextLine().equals("2")) {
                RavintolaUI.login();
            }

            return;

        }
    }

}
