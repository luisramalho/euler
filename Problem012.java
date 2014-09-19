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
        int t = 1;
        int a = 1;
        int count = 0;
        while (count <= LIMIT) {
            count = 0;
            a += 1;
            t += a;
            int ttx = (int) Math.sqrt(t);
            for (int i = 1; i <= ttx; i++) {
                if (t % i == 0) {
                    count += 2;
                }

                // correction for a perfect square
                if (t == ttx * ttx) {
                    count--;
                }
            }
        }
        System.out.println(t);
    }

}
