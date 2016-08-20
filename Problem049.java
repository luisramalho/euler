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

/**
 * Prime permutations.
 *
 * @author luisramalho
 */
public class Problem049 {

    public String solve() {
        int first, second, third;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> primes = getPrimes(1488, 10_000);
        for (int i = 0; i < primes.size() - 1; i++) {
            first = primes.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                second = primes.get(j);
                third = second + (second - first);
                if (third < 10_000 && isPrime(third)) {
                    if (isPermutation(first, second)) {
                        if (isPermutation(first, third)) {
                            sb.append(first).append(second).append(third);
                            return sb.toString();
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

    /**
     * Computes all prime numbers between start and end.
     *
     * @param start the smallest possible prime
     * @param end the largest possible prime
     * @return all prime numbers between start and end
     */
    private ArrayList<Integer> getPrimes(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Checks if numbers number is prime.
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
     * Computes is two integers are permutations of one another.
     *
     * @param x first integer
     * @param y second integer
     * @return  <code>true</code> if they are permutations of one another;
     * <code>false</code> otherwise.
     */
    private boolean isPermutation(int x, int y) {
        int[] numbers = new int[10];

        int t = x;
        while (t > 0) {
            numbers[t % 10]++;
            t /= 10;
        }

        t = y;
        while (t > 0) {
            numbers[t % 10]--;
            t /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (numbers[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
