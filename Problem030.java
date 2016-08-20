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
 * Digit fifth powers.
 *
 * @author luisramalho
 */
public class Problem030 {

    /**
     * Computes the sum of all the numbers that can be written as the sum of
     * fifth powers of their digits.
     *
     * @return the sum of all the numbers.
     */
    public int solve() {
        int sum;
        String number;
        int digitFifthPowers = 0;
        for (int i = 2; i < Math.pow(9, 5) * 6; i++) {
            sum = 0;
            number = Integer.toString(i);
            for (int j = 0; j < number.length(); j++) {
                sum += Math.pow(number.charAt(j) - '0', 5);
            }
            if (i == sum) {
                digitFifthPowers += i;
            }
        }
        return digitFifthPowers;
    }
}
