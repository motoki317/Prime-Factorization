package main;

import util.InputUtils;

public class Main {

    public static void main(String[] args) {

        InputUtils input = new InputUtils();

        long n;
        do {
            n = input.askLongInput("Input the number, type -1 to end.");

            PrimeFact f = new PrimeFact(n);
            f.println();
        } while (n != -1);

    }

}
