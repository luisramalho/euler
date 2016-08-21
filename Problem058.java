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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Spiral primes
 *
 * Created on : 20/08/16
 * Author     : luisramalho
 */
public class Problem058 {

    public int solve() {
        int primes = 0;
        double diagonalNumbers;
        double percentageOfPrimes = 100;
        ArrayList<Integer> numbers;

        int count = 2;
        while (percentageOfPrimes > 10) {
            numbers = getDiagonalNumbersForLoop(count);
            diagonalNumbers = (double) (count * 4 - 3);
            primes += getNumberOfPrimes(numbers);
            percentageOfPrimes = (primes / diagonalNumbers) * 100;
            count++;
        }
        return (count - 1) * 2 - 1;
    }

    /**
     * Computes the number of primes in an ArrayList.
     *
     * @param numbers the ArrayList of numbers.
     * @return the number of primes in the ArrayList.
     */
    private int getNumberOfPrimes(ArrayList<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Computes the diagonal numbers for the a certain square spiral.
     *
     * @param n the loop number of the square spiral.
     * @return ArrayList of the diagonal numbers for the square spiral.
     */
    public ArrayList<Integer> getDiagonalNumbersForLoop(int n) {
        ArrayList<Integer> diagonalNumbers = new ArrayList<>();
        if (n < 1) return diagonalNumbers;

        int offset = (n * 2) - 2;
        int currentDiagonalNumber = getFirstDiagonal(n);
        int lastDiagonalNumber = getLastDiagonal(n);

        diagonalNumbers.add(currentDiagonalNumber);
        while (currentDiagonalNumber != lastDiagonalNumber) {
            currentDiagonalNumber += offset;
            diagonalNumbers.add(currentDiagonalNumber);
        }

        return diagonalNumbers;
    }

    /**
     * Computes the first diagonal number in a square spiral.
     *
     * @param n the loop number of the square spiral.
     * @return the first diagonal number in a square spiral.
     */
    public int getFirstDiagonal(int n) {
        return getLastDiagonal(n) - (n - 1) * 6;
    }

    public int getLastDiagonal(int n) {
        int sideLength = n * 2 - 1;
        return sideLength * sideLength;
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
}
