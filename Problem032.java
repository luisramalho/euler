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

import java.util.HashSet;
import java.util.Set;

/**
 * Pandigital products
 *
 * @author luisramalho
 */
public class Problem032 {

    public int solve() {
        int product;
        StringBuilder s = new StringBuilder("");
        Set<Integer> products = new HashSet<>();
        for (int i = 4; i < 50; i++) {
            for (int j = 100 + i; j < 8000 / i; j++) {
                product = i * j;
                s.append(i).append(j).append(product);
                if (s.length() == 9) {
                    if (isPandigital(Integer.parseInt(s.toString()))) {
                        products.add(product);
                    }
                }
                s.setLength(0);
            }
        }
        
        int count = 0;
        for (Integer i : products) {
            count += i;
        }

        return count;
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
