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
 * Digit canceling fractions.
 *
 * @author luisramalho
 */
public class Problem033 {

    public int solve() {
        double division;
        double candidate;
        int numeratorProduct = 1;
        int denominatorProduct = 1;
        int leftNumerator, rightNumerator;
        int leftDenominator, rightDenominator;
        for (double numerator = 11; numerator < 100; numerator++) {
            if (numerator % 10 == 0) {
                continue;
            }
            for (double denominator = 99; denominator > numerator; denominator--) {
                if (denominator % 10 == 0) {
                    continue;
                }
                division = numerator / denominator;

                leftNumerator = (int) numerator / 10;
                rightNumerator = (int) numerator % 10;
                leftDenominator = (int) denominator / 10;
                rightDenominator = (int) denominator % 10;

                candidate = (double) leftNumerator / rightDenominator;

                if (division == candidate && rightNumerator == leftDenominator) {
                    numeratorProduct *= numerator;
                    denominatorProduct *= denominator;
                }

            }
        }
        return denominatorProduct / gcd(numeratorProduct, denominatorProduct);
    }

    /**
     * Computes the greatest common divisor.
     *
     * @param a dividend
     * @param b divisor
     * @return the greatest common divisor.
     */
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
