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
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 * 
 * @author luisramalho
 * 
 */
public final class Problem009 {

    /**
     * Result of sum of Pythagorean triplets.
     */
    private static final int SUM = 1000;

    /**
     * Private constructor.
     */
    private Problem009() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        System.out.println(productOfPythagoreanTriplet(SUM));
    }

    /**
     * Computes the Pythagorean triplet for which a + b + c = sum. A Pythagorean
     * triplet is a set of three natural numbers, a < b < c.
     * 
     * @param sum
     *            The sum a + b + c.
     * 
     * @return the product abc.
     */
    private static int productOfPythagoreanTriplet(final int sum) {
        int c = 0;
        for (int a = 1; a < sum / 3; a++) {
            for (int b = 1; b < sum / 2; b++) {
                c = sum - a - b; // a + b + c = 1000
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    return a * b * c;
                }
            }
        }
        return c;
    }

}
