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
 * The four adjacent digits in the 1000-digit number that have the greatest
 * product are 9 × 9 × 8 × 9 = 5832.
 * 
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that have the
 * greatest product. What is the value of this product?
 * 
 * @author luisramalho
 * 
 */
public final class Problem008 {

    /**
     * Number of adjacent digits.
     */
    private static final int ADJACENT_DIGITS = 13;

    /**
     * 1000-digit number.
     */
    private static final String NUMBER = "7316717653133062491922511967442657474"
            + "2355349194934969835203127745063262395783180169848018694788518438"
            + "5861560789112949495459501737958331952853208805511125406987471585"
            + "2386305071569329096329522744304355766896648950445244523161731856"
            + "4030987111217223831136222989342338030813533627661428280644448664"
            + "5238749303589072962904915604407723907138105158593079608667017242"
            + "7121883998797908792274921901699720888093776657273330010533678812"
            + "2023542180975125454059475224352584907711670556013604839586446706"
            + "3244157221553975369781797784617406495514929086256932197846862248"
            + "2839722413756570560574902614079729686524145351004748216637048440"
            + "3199890008895243450658541227588666881164271714799244429282308634"
            + "6567481391912316282458617866458359124566529476545682848912883142"
            + "6076900422421902267105562632111110937054421750694165896040807198"
            + "4038509624554443629812309878799272442849091888458015616609791913"
            + "3875499200524063689912560717606058861164671094050775410022569831"
            + "5520005593572972571636269561882670428252483600823257530420752963"
            + "450";

    /**
     * Private constructor.
     */
    private Problem008() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        long greatestProduct = 0L;
        for (int i = 0; i < NUMBER.length() - ADJACENT_DIGITS; i++) {
            String sub = NUMBER.substring(i, i + ADJACENT_DIGITS);
            int indexOfLastZero = sub.lastIndexOf("0");
            if (indexOfLastZero != -1) { // zero present
                i += indexOfLastZero; // Change i to the element after last zero
            } else {
                long candidate = product(sub);
                if (candidate > greatestProduct) {
                    greatestProduct = candidate;
                }
            }
        }
        System.out.println(greatestProduct);
    }

    /**
     * Calculates the product of each and all the numbers in a given string.
     * 
     * @param str
     *            String with numbers.
     * @return product of all the numbers in a given string.
     */
    private static long product(final String str) {
        String[] a = str.split("");
        long total = 1L;
        for (int i = 1; i < a.length; i++) {
            total *= Integer.parseInt(a[i]);
        }
        return total;
    }

}
