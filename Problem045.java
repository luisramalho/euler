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
 * Triangular, pentagonal, and hexagonal.
 *
 * @author luisramalho
 */
public class Problem045 {

    public long solve() {
        long i = 166;
        long j = 144;
        long pentagonal = getPentagonal(i);
        long hexagonal = getHexagonal(j);

        do {
            if (pentagonal < hexagonal) {
                pentagonal = getPentagonal(i++);
            } else {
                hexagonal = getHexagonal(j++);
            }
        } while (pentagonal != hexagonal);

        return hexagonal;
    }

    /**
     * Computes the pentagonal n number.
     *
     * @param n the number
     * @return the pentagonal n number
     */
    private long getPentagonal(long n) {
        return n * (3 * n - 1) / 2;
    }

    /**
     * Computes the hexagonal n number.
     *
     * @param n the number
     * @return the hexagonal number
     */
    private long getHexagonal(long n) {
        return n * (2 * n - 1);
    }
}
