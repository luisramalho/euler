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
import java.util.ArrayList;

/**
 * Square root convergents.
 *
 * @author luisramalho
 */
public class Problem057 {
    
    public int solve() {
        ArrayList<BigInteger> n = new ArrayList<>();
        n.add(BigInteger.valueOf(3)); // first numerator
        n.add(BigInteger.valueOf(7)); // second numerator
        
        ArrayList<BigInteger> d = new ArrayList<>();
        d.add(BigInteger.valueOf(2)); // first denominator
        d.add(BigInteger.valueOf(5)); // second denominator
        
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 1; i < 1000; i++) {
            n.add(n.get(i).multiply(two).add(n.get(i - 1)));
            d.add(d.get(i).multiply(two).add(d.get(i - 1)));
        }

        int count = 0;
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i).toString().length() > d.get(i).toString().length()) {
                count++;
            }
        }
        
        return count;
    }
}
