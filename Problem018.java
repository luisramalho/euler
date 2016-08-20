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
 *
 * @author luisramalho
 *
 */
public final class Problem018 {

    /**
     * Triangle.
     */
    static final String[][] TRIANGLE = {
            { "75" },
            { "95", "64" },
            { "17", "47", "82" },
            { "18", "35", "87", "10" },
            { "20", "04", "82", "47", "65" },
            { "19", "01", "23", "75", "03", "34" },
            { "88", "02", "77", "73", "07", "63", "67" },
            { "99", "65", "04", "28", "06", "16", "70", "92" },
            { "41", "41", "26", "56", "83", "40", "80", "70", "33" },
            { "41", "48", "72", "33", "47", "32", "37", "16", "94", "29" },
            { "53", "71", "44", "65", "25", "43", "91", "52", "97", "51", "14" },
            { "70", "11", "33", "28", "77", "73", "17", "78", "39", "68", "17",
                    "57" },
            { "91", "71", "52", "38", "17", "14", "91", "43", "58", "50", "27",
                    "29", "48" },
            { "63", "66", "04", "68", "89", "53", "67", "30", "73", "16", "69",
                    "87", "40", "31" },
            { "04", "62", "98", "27", "23", "09", "70", "98", "73", "93", "38",
                    "53", "60", "04", "23" } };

    /**
     * Problem018 is non-instantiable.
     */
    private Problem018() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int height = TRIANGLE.length;
        int largestWidth = TRIANGLE[TRIANGLE.length - 1].length;
        int[][] values = new int[height][largestWidth];

        // Populating values[][] the hacky way
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < largestWidth; j++) {
                try {
                    values[i][j] = Integer.parseInt(TRIANGLE[i][j]);
                } catch (Exception e) {
                    values[i][j] = 0;
                }

            }
        }
        int left, right;
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                left = values[i + 1][j];
                right = values[i + 1][j + 1];
                values[i][j] += Math.max(left, right);
            }
        }
        System.out.println(values[0][0]);
    }
}
