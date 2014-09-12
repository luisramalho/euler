package euler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author luisramalho
 * 
 */
public final class Problem7 {
  
  /**
   * Number of primes.
   */
  static final int NUMBER_OF_PRIMES = 10_001;
  
  /**
   * Private constructor.
   */
  private Problem7() { };

  /**
   * Main method.
   * @param args Arguments.
   */
  public static void main(final String[] args) {
    int[] primeNumbers = primeNumbers(NUMBER_OF_PRIMES);
    int lastPrime = primeNumbers[NUMBER_OF_PRIMES - 1];
    System.out.println(lastPrime);
  }

  /**
   * Computes n prime numbers.
   * @param n   Number of prime numbers.
   * @return    ArrayList of prime numbers.
   */
  private static int[] primeNumbers(final int n) {
    int[] primes = new int[n];
    
    int i = 0;
    int count = 0;
    while (count < n) {
      if (isPrime(i)) {
        primes[count] = i;
        count++;
      }
      i++;
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
