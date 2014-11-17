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

import java.math.BigInteger;

/**
 *
 * @author luisramalho
 */
public class Problem055 {

    public int solve() {
        int lychrelNumbers = 0;
        int i = 0;
        BigInteger temp;
        BigInteger one = BigInteger.ONE;
        BigInteger b = new BigInteger("10");
        BigInteger limit = new BigInteger("10000");
        for (; b.compareTo(limit) < 0; b = b.add(one), i = 0) {
            temp = b;
            do {
                temp = temp.add(reverse(temp));
                i++;
            } while (!isPalindrome(temp.toString()) && i < 50);

            // Lychrel number
            if (i == 50) {
                lychrelNumbers++;
            }
        }
        return lychrelNumbers;
    }

    /**
     * Computes the reverse of a BigInteger.
     *
     * @param b the BigInteger
     * @return the reverse of a BigInteger
     */
    private BigInteger reverse(BigInteger b) {
        StringBuilder r = new StringBuilder(b.toString()).reverse();
        return new BigInteger(r.toString());
    }

    /**
     * Computes if a string is a palindrome.
     *
     * @param str the string
     * @return  <true> if the string is a palindrome; <false> otherwise.
     */
    private boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }
}
