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
 * Longest Collatz sequence.
 *
 * @author luisramalho
 *
 */
public final class Problem014 {

    /**
     * Highest number to check.
     */
    static final int LIMIT = 1_000_000;

    /**
     * Private constructor.
     */
    private Problem014() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        long start = System.currentTimeMillis();
        long current = 0;
        int longestChain = 0;
        int chainLength = 0;
        int startingNumber = 0;
        boolean[] checked = new boolean[LIMIT];
        int[] chainsLength = new int[LIMIT];
        int tempStartingNumber = 0;
        for (int i = 1; i < LIMIT; i++) {
            current = i;
            chainLength = 0;
            tempStartingNumber = i;
            do {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }
                chainLength++;

                // Caching and checking for lower chains already solved.
                if (current < tempStartingNumber && checked[(int) current]) {
                    chainLength += chainsLength[(int) current];
                    chainsLength[tempStartingNumber] = chainLength;
                    current = 1;
                }
            } while (current > 1);

            checked[tempStartingNumber] = true;

            if (chainLength > longestChain) {
                longestChain = chainLength;
                startingNumber = tempStartingNumber;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(startingNumber + " (" + (longestChain + 1) + ")");
        System.out.println("Took: " + (end - start) + "ms");
    }
}
