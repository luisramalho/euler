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

import java.util.Arrays;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author luisramalho
 * 
 */
public final class Problem010 {

    /**
     * Max prime number to check.
     */
    static final int LIMIT = 2_000_000;

    /**
     * Sieve size without even numbers.
     */
    static final int SIEVE_BOUND = (LIMIT - 1) / 2;

    /**
     * Cross limit, because any smaller multiple of a next number p that has a
     * divisor less than p has already been crossed out as a multiple of that.
     */
    static final double CROSS_LIMIT = (Math.sqrt(LIMIT) - 1) / 2;

    /**
     * Private constructor.
     */
    private Problem010() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        boolean[] sieve = new boolean[SIEVE_BOUND];
        Arrays.fill(sieve, false);

        for (int i = 1; i < CROSS_LIMIT; i++) {
            if (!sieve[i]) { // 2 * i + 1 is prime, mark multiples
                for (int j = 2 * i * (i + 1); j < SIEVE_BOUND; j += 2 * i + 1) {
                    sieve[j] = true;
                }
            }
        }

        long sum = 2; // 2 is prime

        for (int i = 1; i < SIEVE_BOUND; i++) {
            if (!sieve[i]) {
                sum += 2 * i + 1;
            }
        }

        System.out.println(sum);
    }
}