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

/**
 * Sub-string divisibility.
 *
 * @author luisramalho
 */
public class Problem043 {

    /**
     * Maximum number of permutations for a 10 digit number, aka 10!.
     */
    private static int limit = factorial(10);

    /**
     * The first seven prime numbers.
     */
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17};

    /**
     * The sum of all 0 to 9 pandigital numbers with the property described in
     * Euler's Problem #43.
     */
    private static long sum = 0;

    /**
     * Recursion state.
     */
    private static boolean finished = false;

    public long solve() {
        permutation("", "1406357289");
        return sum;
    }

    /**
     * Computes all permutations of a string so that it finds the sum of all 0
     * to 9 pandigital numbers with the property described in Euler's Problem
     * #43.
     *
     * @param prefix helper holding the prefixes.
     * @param s characters to be permutated.
     */
    private static void permutation(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            if (hasSubStringDivisibility(prefix)) {
                sum += Long.valueOf(prefix);
            }
            if (--limit == 0) {
                finished = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (finished) {
                    return;
                }
                permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    /**
     * Checks for sub-string divisibility according to property described in
     * Euler's Problem #43.
     *
     * @param str the string
     * @return <code>true</true> if the string has sub-string divisibility;
     * <code>false</code> otherwise.
     */
    private static boolean hasSubStringDivisibility(String str) {
        String sub;
        int candidate;
        for (int i = 0; i < primes.length; i++) {
            sub = str.substring(i + 1, i + 4);
            candidate = Integer.valueOf(sub);
            if (candidate % primes[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Computes the factorial of a number.
     *
     * @param n the number
     * @return the factorial of a number
     */
    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
