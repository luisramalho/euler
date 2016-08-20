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
 * Number letter counts.
 *
 * @author luisramalho
 *
 */

public final class Problem017 {

    /**
     * "Tens" names from 10 to 90.
     */
    private static final String[] TENS = { "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };

    /**
     * Numbers' names from 1 to 19.
     */
    private static final String[] NUMBERS = { "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };

    /**
     * Problem017 is non-instantiable.
     */
    private Problem017() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int letters = 0;

        // From 1 to 19
        for (int i = 1; i < NUMBERS.length + 1; i++) {
            letters += NUMBERS[i - 1].length();
        }

        // From 20 to 99
        for (int i = 0; i < TENS.length; i++) {
            letters += TENS[i].length();
            for (int j = 0; j < 9; j++) {
                letters += TENS[i].length() + NUMBERS[j].length();
            }
        }

        int lettersTo99 = letters;

        // From 100 to 999
        for (int i = 0; i < 9; i++) {
            letters += NUMBERS[i].length() + "hundred".length();
            letters += NUMBERS[i].length() * 99 + "hundred".length() * 99
                    + "and".length() * 99 + lettersTo99;
        }

        letters += "one".length() + "thousand".length();

        System.out.println(letters);
    }

}
