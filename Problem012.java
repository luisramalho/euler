package euler;

/**
 * Highly divisible triangular number.
 *
 * @author luisramalho
 *
 */
public final class Problem012 {

    /**
     * Maximum number of factors to check.
     */
    static final int LIMIT = 500;

    /**
     * Primes.
     */
    static final int P = 1000;

    /**
     * Private constructor.
     */
    private Problem012() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int n = 3;
        int dn = 2;
        int count = 0;
        int n1, dn1, i, exponent;
        int[] primes = primes(P);
        while (count <= LIMIT) {
            n += 1;
            n1 = n;
            if (n1 % 2 == 0) {
                n1 /= 2;
            }
            dn1 = 1;
            for (i = 1; i <= P; i++) {
                if (primes[i] * primes[i] > n1) {
                    dn1 *= 2;
                    break;
                }

                exponent = 1;
                while (n1 % primes[i] == 0) {
                    exponent++;
                    n1 /= primes[i];
                }
                if (exponent > 1) {
                    dn1 *= exponent;
                }
                if (n1 == 1) {
                    break;
                }
            }
            count = dn * dn1;
            dn = dn1;
        }
        System.out.println(n * (n - 1) / 2);
    }

    /**
     * Calculates primes.
     *
     * @param n
     *            Max prime.
     * @return array of primes.
     */
    private static int[] primes(final int n) {
        int[] p = new int[n];
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                p[count] = i;
                count++;
            }
        }
        return p;
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
