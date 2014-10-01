package euler;

import java.math.BigInteger;

/**
 *
 * @author luisramalho
 *
 */
public final class Problem020 {

    /**
     * Problem020 is non-instantable.
     */
    private Problem020() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        String fac = factorial(100).toString();
        int sum = 0;
        for (int i = 0; i < fac.length(); i++) {
            sum += Character.getNumericValue(fac.charAt(i));
        }
        System.out.println(sum);
    }

    /**
     * Computes factorial number.
     *
     * @param n
     *            number for factorial to be computed.
     * @return factorial number.
     */
    private static BigInteger factorial(final int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}
