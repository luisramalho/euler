/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Luís Ramalho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Non-abundant sums.
 *
 * @author luisramalho
 *
 */
public final class Problem023 {

    /**
     * All integers greater than 28123 can be written as the sum of two abundant
     * numbers.
     */
    static final int LIMIT = 28123;

    /**
     * Problem023 is non-instantiable.
     */
    private Problem023() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(sum());
    }

    /**
     * Finds the sum of all the positive integers which cannot be written as the
     * sum of two abundant numbers.
     *
     * @return the sum of all the positive integers which cannot be written as
     *         the sum of two abundant numbers.
     */
    private static long sum() {
        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
        for (int i = 1; i < LIMIT; i++) {
            if (isAbundant(i)) {
                abundantNumbers.add(i);
            }
        }

        Set<Integer> s = new HashSet<Integer>();
        int current, abundantNumberSum;
        for (int i = 0; i < abundantNumbers.size(); i++) {
            current = abundantNumbers.get(i);
            for (int j = 0; j < abundantNumbers.size(); j++) {
                abundantNumberSum = current + abundantNumbers.get(j);
                if (abundantNumberSum <= LIMIT) {
                    s.add(abundantNumberSum);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!s.remove(i)) { // false if this set contained the specified
                                // element
                sum += i;
            }
        }

        return sum;
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

    /**
     * Computes if a number is abundant. A number is abundant if the sum of its
     * proper divisors exceeds n.
     *
     * @param n
     *            the number to be checked.
     * @return <code>true</code> if the number n is abundant; <code>false</code>
     *         otherwise.
     */
    private static boolean isAbundant(final int n) {
        return d(n) > n;
    }
}
