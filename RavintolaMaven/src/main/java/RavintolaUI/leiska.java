/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaUI;

import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class leiska {

    public static void viiva() {
        System.out.println("-----------------");
    }

    public static String kysy() {
        viiva();
        System.out.print("Select: ");
        Scanner s = new Scanner(System.in);
        String palautus = s.nextLine();
        viiva();
        return palautus;
    }

}
