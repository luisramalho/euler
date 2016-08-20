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
 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... +
 * 10^2 = 385 The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640. Find the difference
 * between the sum of the squares of the first one hundred natural numbers and
 * the square of the sum.
 * 
 * @author luisramalho
 * 
 */

public final class Problem006 {

    /**
     * Ceiling natural number.
     */
    static final int UP_LIMIT = 100;

    /**
     * Private constructor.
     */
    private Problem006() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        // sum(n) = n(n + 1)/2
        int sum = (UP_LIMIT * (UP_LIMIT + 1)) / 2;

        // sum sq = (2n + 1)(n + 1)n/6
        int sumSquares = ((2 * UP_LIMIT + 1) * (UP_LIMIT + 1) * UP_LIMIT) / 6;

        double squareSum = Math.pow(sum, 2);

        System.out.println((int) squareSum - sumSquares);
    }

}
