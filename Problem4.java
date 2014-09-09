package euler;

/*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 */

public class Problem4 {

  public static void main(String[] args) {
    System.out.println(largestPalindromeFromDigits(3));
  }
  
  public static int largestPalindromeFromDigits(int digits) {
    int productOfDigits, largestPalindrome = 0;
    int largestNumber = largestNumberFromDigits(digits);
    int smallestNumber = smallestNumberFromDigits(digits);
    for (int i = largestNumber; i > smallestNumber; i--) {
      for (int j = largestNumber; j > smallestNumber; j--) {
        productOfDigits = i * j;
        if (isPalindrome(productOfDigits) && productOfDigits > largestPalindrome) {
          largestPalindrome = productOfDigits;
        }
      }
    }
    return largestPalindrome;
  }

  private static int largestNumberFromDigits(int digits) {
    StringBuilder sb = new StringBuilder();
    int largestNumber = 0;
    for (int i = 0; i < digits; ++i ) {
      sb.append("9");
    }
    largestNumber = Integer.valueOf(sb.toString());
    return largestNumber;
  }

  private static int smallestNumberFromDigits(int digits) {
    return largestNumberFromDigits(digits - 1);
  }

  private static boolean isPalindrome(int product) {
    String str = String.valueOf(product);
    for (int i = 0; i < str.length()/2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}
