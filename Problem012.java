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
        int triangleNumber = 0;
        int factors = 0;
        int i = 1;
        while (factors <= LIMIT) {
            triangleNumber = triangleNumber(i);
            factors = factorsCount(triangleNumber);
            i++;
        }
        System.out.println(i);
    }

    /**
     * Calculates triangle numbers.
     *
     * @param n
     *            triangle number to be found.
     * @return triangle number.
     */
    private static int triangleNumber(final int n) {
        return (n * (n + 1)) / 2;
    }

    /**
     * Computes the number of factors.
     *
     * @param n
     *            number to be checked for factors.
     * @return number of factors.
     */
    private static int factorsCount(final long n) {
        int count = 2; // 1 and itself
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

}
