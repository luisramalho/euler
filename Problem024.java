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
 * Lexicographic permutations.
 *
 * @author luisramalho
 *
 */
public final class Problem024 {

    /**
     * Lexicographic permutation to check.
     */
    private static int limit = 1_000_000;

    /**
     * Recursion state.
     */
    private static boolean finished = false;

    /**
     * Prroblem024 is non-instantiable.
     */
    private Problem024() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        permutation("", "0123456789");
    }

    /**
     * Computes all permutations and displays the millionth.
     *
     * @param prefix
     *            helper holding the prefixes.
     * @param s
     *            characters to be permutated.
     */
    private static void permutation(final String prefix, final String s) {
        int n = s.length();
        if (n == 0) {
            if (--limit == 0) {
                System.out.println(prefix);
                finished = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (finished) {
                    return;
                }
                permutation(prefix + s.charAt(i),
                        s.substring(0, i) + s.substring(i + 1));
            }
        }
    }
}
