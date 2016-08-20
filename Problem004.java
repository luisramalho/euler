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

/*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 */

public class Problem004 {

    public static void main(String[] args) {
        System.out.println(largestPalindromeFromDigits(3));
    }

    public static int largestPalindromeFromDigits(int digits) {
        int productOfDigits, largestPalindrome = 0;
        int largestNumber = largestNumberFromDigits(digits);
        int smallestNumber = smallestNumberFromDigits(digits);
        for (int i = largestNumber; i > smallestNumber; i--) {
            for (int j = largestNumber; j > smallestNumber; j--) {
                productOfDigits = i * j;
                if (isPalindrome(productOfDigits)
                        && productOfDigits > largestPalindrome) {
                    largestPalindrome = productOfDigits;
                }
            }
        }
        return largestPalindrome;
    }

    private static int largestNumberFromDigits(int digits) {
        StringBuilder sb = new StringBuilder();
        int largestNumber = 0;
        for (int i = 0; i < digits; ++i) {
            sb.append("9");
        }
        largestNumber = Integer.valueOf(sb.toString());
        return largestNumber;
    }

    private static int smallestNumberFromDigits(int digits) {
        return largestNumberFromDigits(digits - 1);
    }

    private static boolean isPalindrome(int product) {
        String str = String.valueOf(product);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
