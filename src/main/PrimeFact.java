package main;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class PrimeFact {

    private final Long orig;
    private LinkedHashMap<Long, Integer> factorization;

    public PrimeFact(Long num) {
        orig = num;
        factorization = factorize(num);
    }

    public void println() {
        System.out.print(orig);
        if (factorization.isEmpty()) System.out.println(" = 1");
        else if (this.isPrime()) System.out.println(" is a prime!");
        else {
            System.out.println(
                    " = " +
                    factorization.entrySet().stream().sorted(
                            (o1, o2) -> (int) (o1.getKey() - o2.getKey())
                    ).map(
                            e -> e.getKey() + (e.getValue() != 1 ? "^" + e.getValue() : "")
                    ).collect(Collectors.joining(" * "))
            );
        }
    }

    public boolean isPrime() {
        return factorization.size() == 1 && factorization.containsValue(1);
    }

    private static LinkedHashMap<Long, Integer> factorize(long num) {

        LinkedHashMap<Long, Integer> fact;

        if (num == 1L) return new LinkedHashMap<>();

        long sqrt = (long) Math.floor(Math.sqrt(num));

        for (long p : Primes.getPrimes(sqrt)) {
            if (num % p == 0) {
                fact = factorize(num/p);
                if (fact.containsKey(p)) fact.put(p, fact.get(p) + 1);
                else fact.put(p, 1);
                return fact;
            }
        }

        fact = new LinkedHashMap<>();
        fact.put(num, 1);
        return fact;
    }

}
