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
 * Pandigital multiples.
 *
 * @author luisramalho
 */
public class Problem038 {

    public int solve() {
        int i = 1;
        int max = 0;
        int concatenated;
        StringBuilder s = new StringBuilder("");
        for (int n = 9; n < 10_000; n++) {
            while (s.length() <= 9) {
                s.append(n * i++);
                if (s.length() == 9) {
                    concatenated = Integer.parseInt(s.toString());
                    if (isPandigital(concatenated)) {
                        max = Math.max(max, concatenated);
                    }
                }
            }
            s.setLength(0);
            i = 1;
        }

        return max;
    }

    /**
     * Computes if s is is 1 through 9 pandigital.
     *
     * @param n integer to be checked for pandigitality.
     * @return <true> if is 1 through 9 pandigital; <false> otherwise.
     */
    private boolean isPandigital(int n) {
        int digits = 0;
        int count = 0;
        int tmp;

        for (; n > 0; n /= 10, count++) {
            tmp = digits;
            digits |= 1 << (n % 10) - 1;
            if (tmp == digits) {
                return false;
            }
        }
        return digits == (1 << count) - 1;
    }
}
