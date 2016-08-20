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
 * Number spiral diagonals.
 *
 * @author luisramalho
 */
public class Problem028 {

    /**
     * Matrix limit.
     */
    private static final int LIMIT = 1001 * 1001;

    public int solve() {
        int count = 0;
        int dimension = 2;
        int sum = 1;
        int i = 3;
        while (i <= LIMIT) {
            sum += i;
            count++;

            // For every 4 numbers found, the dimension goes up by 2.   
            if (count == 4) {
                dimension += 2;
                count = 0;
            }
            i += dimension;
        }

        return sum;
    }
}
