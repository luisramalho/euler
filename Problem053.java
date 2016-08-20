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
 * Combinatoric selections.
 *
 * @author luisramalho
 */
public class Problem053 {

    public int solve() {
        int count = 0;
        BigInteger bc, limit = BigInteger.valueOf(1_000_000);
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                bc = getBinomialCoefficient(n, r);
                if (bc.compareTo(limit) == 1) {
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * Computes the binomial coefficient.
     *
     * @param n possibilities
     * @param r unordered outcomes, r ≤ n
     * @return the binomial coefficient.
     */
    private BigInteger getBinomialCoefficient(int n, int r) {
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger br = BigInteger.valueOf(r);
        return fact(bn).divide(fact(br).multiply(fact(bn.subtract(br))));
    }

    /**
     * Computes the factorial of a non-negative BigInteger.
     *
     * @param n the non-negative BigInteger.
     * @return the factorial of a non-negative BigInteger
     */
    private BigInteger fact(BigInteger n) {
        if (n.intValue() < 1) {
            return BigInteger.ONE;
        } else {
            return n.multiply(fact(n.subtract(BigInteger.ONE)));
        }
    }
}
