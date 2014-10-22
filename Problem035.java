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
 * Circular primes.
 *
 * @author luisramalho
 */
public class Problem035 {

    final private boolean[] primes = new boolean[1_000_000];

    /**
     * Computes the number of circular primes are there below one million.
     *
     * @return the number of circular primes are there below one million
     */
    public int solve() {
        int circularPrimes = 13; // circular prime below 100
        for (int i = 100; i < 1_000_000; i++) {
            if (areAllRotationsPrime(circularShift(i))) {
                circularPrimes++;
            }
        }
        return circularPrimes;
    }

    /**
     * Computes if all combinations of a number are prime themselves.
     *
     * @param candidateShifts list of all the possible shifts
     * @return <true> if all rotations are prime; <false> otherwise;
     */
    private boolean areAllRotationsPrime(int[] candidateShifts) {
        int current = candidateShifts[candidateShifts.length - 1];
        for (int candidate : candidateShifts) {
            if (candidate < current && !primes[candidate]) {
                return false;
            }

            if (!isPrime(candidate)) {
                return false;
            }

            primes[candidate] = true;
        }
        return true;
    }

    /**
     * Computes all the circular shifts of n.
     *
     * @param n the number to be circular shifted
     * @return all the circular shifts of n
     */
    private int[] circularShift(int n) {
        int length = (int) Math.log10(n) + 1;
        int multiplier = (int) Math.pow(10, length - 1);
        int[] cs = new int[length];
        int right;
        int i = 0;
        while (i < length) {
            right = n % 10;
            n /= 10;
            n += multiplier * right;
            cs[i] = n;
            i++;
        }
        return cs;
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
