package euler;

import java.math.BigDecimal;

/**
 * What is the sum of the digits of the number 2^1000?
 *
 * @author luisramalho
 *
 */
public final class Problem016 {

    /**
     * Problem016 is non-instantiable.
     */
    private Problem016() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int sum = 0;
        BigDecimal result = new BigDecimal(Math.pow(2, 1000));
        BigDecimal divisor = new BigDecimal("10");
        while (result.compareTo(BigDecimal.ZERO) > 0) {
            sum += result.remainder(divisor).intValue();
            result = result.divideToIntegralValue(divisor);
        }
        System.out.println(sum);
    }

}
