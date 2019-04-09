package RavintolaMaven;

import RavintolaUI.RavintolaUI;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class Ravintola {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        while (true) {

            System.out.println("1 = quit");
            System.out.println("2 = log in");
            if (s.nextLine().equals("2")) {
                RavintolaUI.login();
            }

            return;

        }
    }

}
