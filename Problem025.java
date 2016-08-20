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

import java.util.ArrayList;
import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number.
 * 
 * @author luisramalho
 */
public class Problem025 {
    
    /**
     * Number of digits of the target Fibonacci.
     */
    private static final int TARGET = 1000;
    
    /**
     * Number of digits of each Fibonacci.
     */
    private static int digits = 0;
    
    /**
     * Computes the first term in the Fibonacci sequence to contain TARGET digits
     */
    public void solve() {
        ArrayList<BigInteger> fib = new ArrayList<>();
        
        // Base cases
        fib.add(BigInteger.ZERO);
        fib.add(BigInteger.ONE);
        
        while (digits != TARGET) {
            fib.add(fib.get(fib.size() - 1).add(fib.get(fib.size() - 2)));
            digits = fib.get(fib.size() - 1).toString().length();
        }

        System.out.println(fib.size() - 1);
    }
    
}
