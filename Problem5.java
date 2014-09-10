package euler;

import java.util.ArrayList;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author luisramalho
 * 
 */

public final class Problem5 {
  
  /**
   * Private constructor.
   */
  private Problem5() { }

  /**
   * Main method.
   * @param args Arguments.
   */
  public static void main(final String[] args) {
    double smallestMultiple = 1;
    final int largestDivisor = 20;
    final double limit = Math.sqrt(largestDivisor);
    boolean check = true;
    double[] a = new double[largestDivisor];
    ArrayList<Integer> p = primeNumbers(largestDivisor * 2);

    int i = 0;
    while (p.get(i) <= largestDivisor) {
      a[i] = 1;
      if (check) {
        if (p.get(i) <= limit) {
          a[i] = Math.floor(Math.log(largestDivisor) / Math.log(p.get(i)));
        } else {
          check = false;
        }
      }
      smallestMultiple = smallestMultiple * Math.pow(p.get(i), a[i]);
      i++;

    }
    System.out.println((int) smallestMultiple);
  }
  
  /**
   * Computes prime numbers.
   * @param n   Ceiling of maximum prime number.
   * @return    ArrayList of prime numbers.
   */
  private static ArrayList<Integer> primeNumbers(final int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    
    for (int i = 0; i < n; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }
  
  /**
   * Checks if a number is prime.
   * @param n  Number to be checked for primality.
   * @return   <code>true</code> if the number is prime;
   *           <code>false</code> otherwise.
   */
  private static boolean isPrime(final int n) {
    if (n < 2) {
      return false;
    }
    
    if (n == 2) {
      return true;
    }
    
    for (int i = 2; i < Math.sqrt(n) + 1; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
  
}  
