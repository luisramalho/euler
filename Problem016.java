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

import java.math.BigDecimal;

/**
 * What is the sum of the digits of the number 2^1000?
 *
 * @author luisramalho
 *
 */
public final class Problem016 {

    /**
     * Problem016 is non-instantiable.
     */
    private Problem016() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int sum = 0;
        BigDecimal result = new BigDecimal(Math.pow(2, 1000));
        BigDecimal divisor = new BigDecimal("10");
        while (result.compareTo(BigDecimal.ZERO) > 0) {
            sum += result.remainder(divisor).intValue();
            result = result.divideToIntegralValue(divisor);
        }
        System.out.println(sum);
    }

}
