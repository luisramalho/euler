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
 * Champernowne's constant.
 *
 * @author luisramalho
 */
public class Problem040 {

    private static final StringBuilder s = new StringBuilder();

    private static final int LIMIT = 1_000_000;

    public int solve() {
        getIDF(); // irrational decimal fraction
        int product = 1;
        for (int n = 1; n <= LIMIT; n *= 10) {
            product *= d(n - 1);
        }
        return product;
    }

    /**
     * Creates an irrational decimal fraction concatenating the positive
     * integers.
     */
    public void getIDF() {
        int i = 1;
        int digits = 0;
        while (digits <= LIMIT) {
            digits += (int) Math.log10(i) + 1;
            s.append(i++);
        }
    }

    /**
     * Computes the numeric value of a char.
     *
     * @param n the index
     * @return the numeric value
     */
    public int d(int n) {
        char ch = s.charAt(n);
        return Character.getNumericValue(ch);
    }
}
