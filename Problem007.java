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
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author luisramalho
 * 
 */
public final class Problem007 {

    /**
     * Number of primes.
     */
    static final int NUMBER_OF_PRIMES = 10_001;

    /**
     * Private constructor.
     */
    private Problem007() {
    };

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int count = 1; // 2 is the first prime
        int candidate = 1;

        do {
            candidate += 2;
            if (isPrime(candidate)) {
                count++;
            }
        } while (count != NUMBER_OF_PRIMES);

        System.out.println(candidate);
    }

    /**
     * Checks if a number is prime.
     * 
     * @param n
     *            Number to be checked for primality.
     * @return <code>true</code> if the number is prime; <code>false</code>
     *         otherwise.
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
