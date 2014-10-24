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

/**
 * Double-base palindromes.
 *
 * @author luisramalho
 */
public class Problem036 {

    private static final int LIMIT = 1_000_000;

    /**
     * Computes the sum of all numbers, less than LIMIT, which are palindromic
     * in base 10 and base 2.
     *
     * @return the sum of all numbers, less than <code>LIMIT</code> which are
     * palindromic in base 10 and base 2.
     */
    public int solve() {
        String number, binary;
        int sum = 0;
        for (int i = 1; i < LIMIT; i++) {
            number = String.valueOf(i);
            if (isPalindrome(number)) {
                binary = Integer.toBinaryString(i);
                if (isPalindrome(binary)) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    /**
     * Computes if a string is a palindrome.
     *
     * @param str the string
     * @return  <true> if the string is a palindrome; <false> otherwise.
     */
    private static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }
}
