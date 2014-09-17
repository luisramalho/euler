package euler;

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
    static final int MAX_PRIME = 2_000_000;

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
        long sum = 5;
        int i = 5;
        while (i <= MAX_PRIME) {
            if (isPrime(i)) {
                sum += i;
            }
            i += 2;

            if (i < MAX_PRIME && isPrime(i)) {
                sum += i;
            }
            i += 4;
        }
        System.out.println(sum);
    }

    /**
     * Checks if a number is prime.
     * 
     * @param n
     *            Number to be checked for primality.
     * @return <code>true</code> if the number is prime; <code>false</code>
     *         otherwise.
     */
    private static boolean isPrime(final int n) {
        if (n == 1) {
            return false;
        }

        if (n < 4) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        if (n < 9) {
            return true;
        }

        if (n % 3 == 0) {
            return false;
        }

        double r = Math.floor(Math.sqrt(n));
        int f = 5;

        while (f <= r) {
            if (n % f == 0) {
                return false;
            }

            if (n % (f + 2) == 0) {
                return false;
            }

            f += 6;
        }

        return true;
    }
}