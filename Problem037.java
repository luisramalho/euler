/*
 * The MIT License
 *
 * Copyright 2014 luisramalho.
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

/**
 * Truncatable primes.
 *
 * @author luisramalho
 */
public class Problem037 {

    private static final int LIMIT = 11;

    ArrayList<Integer> primes = new ArrayList<>();

    public int solve() {
        int n = 11;
        int sum = 0;
        int count = 0;
        while (count < LIMIT) {
            if (isPrime(n) && isLeftToRightPrime(n) && isRightToLeftPrime(n)) {
                sum += n;
                count++;
            }
            n += 2;
        }
        return sum;
    }

    /**
     * Checks if digits from left to right are prime.
     *
     * @param n the number to be checked
     * @return  <true> digits from left to right are prime; <code>false</code>
     * otherwise.
     */
    private boolean isLeftToRightPrime(int n) {
        int left = n;
        int divisor;
        int digitsToCheck = (int) Math.log10(n);
        for (int i = 0; i < digitsToCheck; i++) {
            divisor = (int) Math.pow(10, (int) Math.log10(n));
            if (divisor != 0) {
                left /= divisor;
                n -= left * divisor;
                if (!isPrime(n)) {
                    return false;
                }
                left = n;
            }
        }
        return true;
    }

    /**
     * Checks if digits from right to left are prime.
     *
     * @param n the number to be checked
     * @return  <true> digits from right to left are prime; <code>false</code>
     * otherwise.
     */
    private boolean isRightToLeftPrime(int n) {
        int digitsToCheck = (int) Math.log10(n);
        for (int i = 0; i < digitsToCheck; i++) {
            n /= 10;
            if (!isPrime(n)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n Number to be checked for primality.
     * @return <code>true</code> if the number is prime; <code>false</code>
     * otherwise.
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
