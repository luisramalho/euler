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
 * Permuted multiples.
 *
 * @author luisramalho
 */
public class Problem052 {

    public int solve() {
        int count;
        for (int i = 1; ; i++) {
            count = 0;
            for (int j = 2; j < 7; j++) {
                if (isPermutation(i, i * j)) {
                    if (++count == 5) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Computes is two integers are permutations of one another.
     *
     * @param x first integer
     * @param y second integer
     * @return  <code>true</code> if they are permutations of one another;
     * <code>false</code> otherwise.
     */
    private boolean isPermutation(int x, int y) {
        int[] numbers = new int[10];

        int t = x;
        while (t > 0) {
            numbers[t % 10]++;
            t /= 10;
        }

        t = y;
        while (t > 0) {
            numbers[t % 10]--;
            t /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (numbers[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
