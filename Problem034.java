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

import java.util.ArrayList;

/**
 * Digit factorials.
 *
 * @author luisramalho
 */
public class Problem034 {

    // ArrayList with first 9 factorials
    private static final ArrayList<Integer> fact = factorial(9);

    public int solve() {
        int totalSum = 0;
        for (int i = 3; i < 7 * fact.get(9); i++) {
            if (i == factorialSum(i)) {
                totalSum += i;
            }
        }
        return totalSum;
    }

    /**
     * Computes the sum of each digit's factorial in n.
     *
     * @param n number for which the digit's factorial sum is computed.
     * @return the sum of the each digit's factorial in n.
     */
    private int factorialSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += fact.get(n % 10);
            n /= 10;
        }
        return sum;
    }

    /**
     * Computes ArrayList with n number of factorials.
     *
     * @param n number of factorials to be computed.
     * @return <code>ArrayList</code> with first <code>n</code> factorials.
     */
    private static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> factArray = new ArrayList<>();
        factArray.add(1); // 0!
        for (int i = 1; i <= n; i++) {
            factArray.add(factArray.get(i - 1) * i);
        }
        return factArray;
    }
}
