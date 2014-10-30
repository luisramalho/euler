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

/**
 * Pandigital prime.
 *
 * @author luisramalho
 */
public class Problem041 {
    public int solve() {
        int max = 0;
        for (int i = 987654321; i > 0; i -= 2) {
            if (isPandigital(i) && isPrime(i)) {
                max = Math.max(max, i);
            }
        }
        return max;
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
    
    /**
     * Computes if s is is 1 through 9 pandigital.
     *
     * @param n integer to be checked for pandigitality.
     * @return <true> if is 1 through 9 pandigital; <false> otherwise.
     */
    private boolean isPandigital(int n) {
        int digits = 0;
        int count = 0;
        int tmp;

        for (; n > 0; n /= 10, count++) {
            tmp = digits;
            digits |= 1 << (n % 10) - 1;
            if (tmp == digits) {
                return false;
            }
        }
        return digits == (1 << count) - 1;
    }
}
