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

public final class Problem006 {

    /**
     * Ceiling natural number.
     */
    static final int UP_LIMIT = 100;

    /**
     * Private constructor.
     */
    private Problem006() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        // sum(n) = n(n + 1)/2
        int sum = (UP_LIMIT * (UP_LIMIT + 1)) / 2;

        // sum sq = (2n + 1)(n + 1)n/6
        int sumSquares = ((2 * UP_LIMIT + 1) * (UP_LIMIT + 1) * UP_LIMIT) / 6;

        double squareSum = Math.pow(sum, 2);

        System.out.println((int) squareSum - sumSquares);
    }

}
