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

import java.text.ParseException;
import java.util.Calendar;

/**
 * Counting Sundays.
 *
 * @author luisramalho
 *
 */
public final class Problem019 {

    /**
     * Problem019 is non-instantiable.
     */
    private Problem019() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     * @throws ParseException
     */
    public static void main(final String[] args) {
        Calendar c = Calendar.getInstance();
        int count = 0;
        for (int i = 1901; i < 2001; i++) {
            for (int month = 0; month < 12; month++) {
                c.set(i, month, 1);
                if (c.get(Calendar.DAY_OF_WEEK) == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * A leap year occurs on any year evenly divisible by 4, but not on a
     * century unless it is divisible by 400.
     *
     * @return <code>true</code> if it's a leap year; <code>false</code>
     *         otherwise.
     */
    private static boolean leapYear(final int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

}
