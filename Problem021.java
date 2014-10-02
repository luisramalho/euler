package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Evaluates the sum of all the amicable numbers under 10000.
 *
 * @author luisramalho
 *
 */
public final class Problem021 {

    /**
     * Cap of amicable numbers to search for.
     */
    static final int LIMIT = 10_000;

    /**
     * Problem021 is non-instatiable.
     */
    private Problem021() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int a, b;
        Set<Integer> amicablePairs = new HashSet<Integer>();
        for (int i = 1; i < LIMIT; i++) {
            a = i;
            b = d(a);
            if (a != b && !amicablePairs.contains(a) && d(b) == a) {
                amicablePairs.add(a);
                amicablePairs.add(b);
            }
        }

        int sumAmicablePairs = 0;
        for (Integer i : amicablePairs) {
            sumAmicablePairs += i;
        }
        System.out.println(sumAmicablePairs);
    }

    /**
     * Computes the sum of proper divisors of n.
     *
     * @param n
     *            number to compute the sum of proper divisors.
     * @return sum of proper divisors of n.
     */
    private static int d(final int n) {
        int sum = 0;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        divisors.add(1); // 1 is always a divisor
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        for (int i = 0; i < divisors.size(); i++) {
            sum += divisors.get(i);
        }
        return sum;
    }
}
