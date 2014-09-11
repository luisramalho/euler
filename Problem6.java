package euler;

/**
 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... +
 * 10^2 = 385 The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640. Find the difference
 * between the sum of the squares of the first one hundred natural numbers and
 * the square of the sum.
 * 
 * @author luisramalho
 * 
 */

public final class Problem6 {
  
  /**
   * Ceiling natural number.
   */
  static final int UP_LIMIT = 100;

  /**
   * Private constructor.
   */
  private Problem6() { }
  
  /**
   * Main method.
   * @param args Arguments.
   */
  public static void main(final String[] args) {
    int sumOfSquares = 0;
    int squareOfSum = 0;
    for (int i = 1; i <= UP_LIMIT; i++) {
      sumOfSquares += i * i;
      squareOfSum += i;
    }
    
    squareOfSum *= squareOfSum;
    
    System.out.println(squareOfSum - sumOfSquares);
  }
  
  

}
