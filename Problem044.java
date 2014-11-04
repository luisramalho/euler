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
 * Pentagon numbers.
 *
 * @author luisramalho
 */
public class Problem044 {

    public int solve() {
        Set<Integer> pentagonals = new HashSet<>();
        for (int i = 1; i < 2500; i++) {
            pentagonals.add(i * (3 * i - 1) / 2);
        }

        for (int j : pentagonals) {
            for (int k : pentagonals) {
                if (k < j) {
                    continue;
                }
                if (!pentagonals.contains(j + k)) {
                    continue;
                }
                if (pentagonals.contains(k - j)) {
                    return k - j;
                }
            }
        }

        return 0;
    }

}
