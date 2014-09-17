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
     * Cross limit, because any smaller multiple of a next number p that has a
     * divisor less than p has already been crossed out as a multiple of that.
     */
    static final double CROSS_LIMIT = Math.sqrt(LIMIT);

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
        boolean[] sieve = new boolean[LIMIT];
        Arrays.fill(sieve, false);

        for (int i = 4; i < LIMIT; i += 2) {
            sieve[i] = true;
        }

        for (int i = 3; i < CROSS_LIMIT; i += 2) {
            if (!sieve[i]) {
                for (int j = i * i; j < LIMIT; j += 2 * i) {
                    sieve[j] = true;
                }
            }
        }

        long sum = 0;

        for (int i = 2; i < LIMIT; i++) {
            if (!sieve[i]) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}