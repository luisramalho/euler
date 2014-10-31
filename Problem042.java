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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Coded triangle numbers.
 *
 * @author luisramalho
 */
public class Problem042 {

    public int solve() {
        int largestWordValue = getLargestWordValue();
        Set<Integer> triangleNumbers = getTriangleValues(largestWordValue);

        int wordValue, count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("p042_words.txt"))) {
            Pattern p = Pattern.compile("\"([A-Z]+)\"");
            Matcher m = p.matcher(br.readLine());
            while (m.find()) {
                wordValue = getWordValue(m.group(1));
                if (triangleNumbers.contains(wordValue)) {
                    count++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Problem042.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    /**
     * Computes triangle values up to n.
     * @param n the limit
     * @return triangle values up to n
     */
    private Set<Integer> getTriangleValues(int n) {
        Set<Integer> triangleNumbers = new HashSet<>();
        int i = 1;
        while (t(i) <= n) {
            triangleNumbers.add(t(i));
            i++;
        }
        return triangleNumbers;
    }

    /**
     * Computes the word value of the largest word in a major dictionary.
     * 
     * Pneumonoultramicroscopicsilicovolcanoconiosis (45 characters)
     *
     * @return the word value of the largest word in a major dictionary
     */
    private int getLargestWordValue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 45; i++) {
            sb.append('Z');
        }
        return getWordValue(sb.toString());
    }

    /**
     * Computes the word value of a word.
     *
     * @param word the word
     * @return the word value
     */
    private int getWordValue(String word) {
        int wordValue = 0;
        for (char ch : word.toCharArray()) {
            wordValue += ch - 'A' + 1;
        }
        return wordValue;
    }

    /**
     * Computes the nth triangle value.
     *
     * @param n the number
     * @return the nth triangle value
     */
    private int t(int n) {
        return n * (n + 1) / 2;
    }
}
