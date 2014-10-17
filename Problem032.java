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
        int count = 0;
        StringBuilder s = new StringBuilder("");
        Set<Integer> products = new HashSet<>();
        for (int i = 1; i < 10_000; i++) {
            for (int j = 1; j < 10_000; j++) {
                s.append(i).append(j);
                s.append(i * j);
                if (s.length() == 9 && isPandigital(s.toString())) {
                    products.add(i * j);
                }
                s.setLength(0);
            }
        }
        return products.stream().map((i) -> i).reduce(count, Integer::sum);
    }

    /**
     * Computes if s is is 1 through 9 pandigital.
     *
     * @param s string to be checked for pandigitality.
     * @return <true> if is 1 through 9 pandigital; <false> otherwise.
     */
    private boolean isPandigital(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            set.add(Character.forDigit(i, 10));
        }
        for (int i = 0; i < s.length(); i++) {
            set.remove(s.charAt(i));
        }
        return set.isEmpty();
    }
}
