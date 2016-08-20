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

/**
 * Powerful digit sum.
 *
 * @author luisramalho
 */
public class Problem056 {

    public long solve() {
        int max = 0;
        BigInteger n;
        for (int a = 0; a < 100; a++) {
            for (int b = 0; b < 100; b++) {
                n = BigInteger.valueOf(a).pow(b);
                max = Math.max(digitalSum(n), max);
            }
        }
        return max;
    }

    /**
     * Computes the digital sum of a number.
     *
     * @param n the number
     * @return the digital sum
     */
    private int digitalSum(BigInteger n) {
        int sum = 0;
        String digits = n.toString();
        for (int i = 0; i < digits.length(); i++) {
            sum += (int) digits.charAt(i) - '0';
        }
        return sum;
    }
}
