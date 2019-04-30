package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    private Scanner sc;

    public InputUtils() {
        sc = new Scanner(System.in);
    }

    /**
     * Ask for integer input in format<br/>
     * (message)<br/>
     * > (input)<br/>
     * Blocking method and repeats if the input is not in the desired format.
     * @param message Message to ask.
     * @return Input integer.
     */

    public int askIntInput(String message) {
        ask(message);

        Integer ret = null;
        boolean c = true;

        while (c) {
            try {
                ret = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid input! Please try again.");
                ask(message);
                sc.nextLine(); // without this, sc.nextInt() above sometimes spits out exception in infinite loop
                continue;
            }
            c = false;
        }

        return ret;
    }

    private static void ask(String message) {
        System.out.println(message);
        System.out.print("> ");
    }
}
