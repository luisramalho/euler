package euler;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime
 * factor of the number 600851475143 ?
 */

public class Problem003 {

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(600851475143l));
    }

    private static long largestPrimeFactor(long n) {
        int largest = 1;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (i > largest) {
                    largest = i;
                }
                n /= i;
            }
        }
        return largest;
    }
}
