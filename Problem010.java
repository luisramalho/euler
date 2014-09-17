package euler;

import java.util.Arrays;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author luisramalho
 * 
 */
public final class Problem010 {

    /**
     * Max prime number to check.
     */
    static final int LIMIT = 2_000_000;

    /**
     * Sieve size without even numbers.
     */
    static final int SIEVE_BOUND = (LIMIT - 1) / 2;

    /**
     * Cross limit, because any smaller multiple of a next number p that has a
     * divisor less than p has already been crossed out as a multiple of that.
     */
    static final double CROSS_LIMIT = (Math.sqrt(LIMIT) - 1) / 2;

    /**
     * Private constructor.
     */
    private Problem010() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        boolean[] sieve = new boolean[SIEVE_BOUND];
        Arrays.fill(sieve, false);

        for (int i = 1; i < CROSS_LIMIT; i++) {
            if (!sieve[i]) { // 2 * i + 1 is prime, mark multiples
                for (int j = 2 * i * (i + 1); j < SIEVE_BOUND; j += 2 * i + 1) {
                    sieve[j] = true;
                }
            }
        }

        long sum = 2; // 2 is prime

        for (int i = 1; i < SIEVE_BOUND; i++) {
            if (!sieve[i]) {
                sum += 2 * i + 1;
            }
        }

        System.out.println(sum);
    }
}