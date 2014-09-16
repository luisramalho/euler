package euler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 * 
 * @author luisramalho
 * 
 */
public final class Problem9 {

    /**
     * Result of sum of Pythagorean triplets.
     */
    private static final int SUM = 1000;

    /**
     * Private constructor.
     */
    private Problem9() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        System.out.println(productOfPythagoreanTriplet(SUM));
    }

    /**
     * Computes the Pythagorean triplet for which a + b + c = sum. A Pythagorean
     * triplet is a set of three natural numbers, a < b < c.
     * 
     * @param sum
     *            The sum a + b + c.
     * 
     * @return the product abc.
     */
    private static int productOfPythagoreanTriplet(final int sum) {
        int c = 0;
        for (int a = 1; a < sum / 3; a++) {
            for (int b = 1; b < sum / 2; b++) {
                c = sum - a - b; // a + b + c = 1000
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    return a * b * c;
                }
            }
        }
        return c;
    }

}
