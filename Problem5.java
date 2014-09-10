package euler;

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
  private Problem5() {
    
  }
  
  /**
   * Highest divisor.
   */
  static final int HIGHEST_DIVISOR = 20;
  
  /**
   * Lowest divisor.
   */
  static final int LOWEST_DIVISOR = 2;

  /**
   * Main method.
   * @param args Arguments.
   */
  public static void main(final String[] args) {
    for (int i = 21; i < Integer.MAX_VALUE; i++) {
      if (evenlyDivisible(i)) {
        System.out.println(i);
        break;
      }
    }
  }
  
  /**
   * Checks if the number can be divided by each of the numbers
   * from LOWEST_DIVISOR to HIGHEST_DIVISOR without any remainder.
   * @param number Number to be checked.
   * @return <code>true</code> if number can be divided without any remainder;
   *         <code>false</code> otherwise.
   */
  private static boolean evenlyDivisible(final int number) {
    for (int i = LOWEST_DIVISOR; i <= HIGHEST_DIVISOR; i++) {
      if (number % i != 0) {
        return false;
      }
    }
    return true;
  }

}
