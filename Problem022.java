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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Names scores.
 *
 * @author luisramalho
 *
 */
public final class Problem022 {

    /**
     * Problem022 is non-instantiable.
     */
    private Problem022() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        try {
            Scanner in = new Scanner(new FileReader(
                    "src/resources/p022_names.txt"));
            String[] names = in.next().replaceAll("\"", "").split(",");
            Arrays.sort(names);
            int total = 0;
            int alphabeticalValue;
            for (int i = 0; i < names.length; i++) {
                alphabeticalValue = 0;
                for (int j = 0; j < names[i].length(); j++) {
                    alphabeticalValue += (names[i].charAt(j) - 'A' + 1);
                }
                total += ((i + 1) * alphabeticalValue);
            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
