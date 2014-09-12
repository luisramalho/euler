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
    int count = 1; // 2 is the first prime
    int candidate = 1;
    
    do {
      candidate += 2;
      if (isPrime(candidate)) {
        count++;
      }
    } while (count != NUMBER_OF_PRIMES);
    
    System.out.println(candidate);
  }
  
  /**
   * Checks if a number is prime.
   * @param n  Number to be checked for primality.
   * @return   <code>true</code> if the number is prime;
   *           <code>false</code> otherwise.
   */
  private static boolean isPrime(final int n) {    
    if (n == 1) {
      return false;
    }
    
    if (n < 4) {
      return true;
    }
    
    if (n % 2 == 0) {
      return false;
    }
    
    if (n < 9) {
      return true;
    }
    
    if (n % 3 == 0) {
      return false;
    }
    
    double r = Math.floor(Math.sqrt(n));
    int f = 5;
    
    while (f <= r) {
      if (n % f == 0) {
        return false;
      }
      
      if (n % (f + 2) == 0) {
        return false;
      }
      
      f += 6;
    }

    return true;
  }
}
