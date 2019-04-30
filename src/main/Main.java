package main;

public class Main {

    public static void main(String[] args) {

        long start = System.nanoTime();

        long beginning = 1000000000L; // inclusive
        long limit = beginning + 2; // exclusive

        for (long i = beginning; i < limit; i++) {
            PrimeFact f = new PrimeFact(i);

            f.println();
        }

        long end = System.nanoTime();

        System.out.println("Took " + (end - start)/1000000D + " ms to compute.");

    }
}
