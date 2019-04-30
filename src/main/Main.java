package main;

import util.InputUtils;

public class Main {

    public static void main(String[] args) {

        InputUtils input = new InputUtils();

        int beginning = input.askIntInput("Input the beginning number");
        int limit = beginning + input.askIntInput("Input how many numbers to continue factorizing.");

        long start = System.nanoTime();

        for (long i = beginning; i < limit; i++) {
            PrimeFact f = new PrimeFact(i);

            f.println();
        }

        long end = System.nanoTime();

        System.out.println("Took " + (end - start)/1000000D + " ms to compute.");

    }

}
