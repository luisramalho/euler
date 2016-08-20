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
 * Reciprocal cycles.
 * @author luisramalho
 */
public class Problem026 {
    
    /**
     * Largest value to check for recurring cycles.
     */
    private static final int LIMIT = 1000;
    
    /**
     * Computes the number with the largest recurring cycle.
     * @return the number with the largest recurring cycle.
     */
    public int solve() {
        int maxCycleSize = 0;
        int longestCycle = 0;
        int tempMaxCycleSize = 0;
        for (int i = 11; i <= LIMIT; i++) {
            tempMaxCycleSize = cycleSize(i);
            if (tempMaxCycleSize > maxCycleSize) {
                maxCycleSize = tempMaxCycleSize;
                longestCycle = i;
            }
        }
        return longestCycle;
    }
    
    /**
     * Computes the number of digits of a recurring cycle.
     * @param i number to be checked for recurring cycles.
     * @return the number of digits of a recurring cycle;
     * <code>0</code> otherwise;
     */
    private int cycleSize(int i) {
        int counter = 0;
        int n = 10 % i;
        for (int k = 1; k <= LIMIT; k++) {
            if (n == 1) {
                return counter;  
            }
            n = (n * 10) % i;
            counter++;
        }
        return 0;
    }
}
