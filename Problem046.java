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
import java.util.List;

/**
 * Goldbach's other conjecture.
 *
 * @author luisramalho
 */
public class Problem046 {

    List<Integer> primes = new ArrayList<>();
    List<Integer> compositeNumbers = new ArrayList<>();

    public int solve() {
        for (int n = 0; n < 10_000; n++) {
            if (isPrime(n)) {
                primes.add(n);
            } else if (n > 33 && n % 2 != 0) {
                compositeNumbers.add(n);
            }
        }

        for (int n : compositeNumbers) {
            if (!checkPremise(n)) {
                return n;
            }
        }
        return 0;
    }

    /**
     * Computes if a composite number can be be written as the sum of a prime
     * and twice a square.
     *
     * @param n the composite number
     * @return <code>true</code> if the premise holds; <code>false</code>
     * otherwise.
     */
    private boolean checkPremise(int n) {
        int i = 0;
        int candidate = 0;
        int prime = primes.get(i);
        while (prime < n) {
            for (int j = 1; candidate < n; j++) {
                candidate = prime + 2 * (j * j);
                if (candidate == n) {
                    return true;
                }
            }
            prime = primes.get(i++);
            candidate = 0;
        }
        return false;
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
