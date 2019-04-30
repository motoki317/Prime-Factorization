package main;

import java.util.LinkedList;
import java.util.List;

public class Primes {

    private static LinkedList<Long> primes;

    static {
        primes = new LinkedList<>();
        primes.add(2L);
    }

    public static LinkedList<Long> getPrimes() {
        return primes;
    }

    /**
     * Returns a list of primes that are smaller than or equal to the given minimum value.
     * @param min Minimum value.
     * @return A prime.
     */

    public static List<Long> getPrimes(long min) {

        if (primes.getLast() < min)
            genPrime(min);

        int index = 0;
        for (long p : primes) {
            if (p > min) break;
            index++;
        }

        return primes.subList(0, index);
    }

    /**
     * Generates primes until it reaches the given minimum value.
     * @param min Minimum value.
     */

    private static void genPrime(long min) {
        for (long biggestKnown = primes.getLast() + 1; biggestKnown <= min; biggestKnown++) {
            if (isPrime(biggestKnown)) primes.add(biggestKnown);
        }
    }

    private static boolean isPrime(long num) {
        int sqrt = (int) Math.floor(Math.sqrt(num));

        for (long p : primes) {
            if (p > sqrt) break;
            if (num % p == 0) return false;
        }

        return true;
    }

}
