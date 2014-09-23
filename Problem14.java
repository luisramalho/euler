package euler;

/**
 * Longest Collatz sequence.
 *
 * @author luisramalho
 *
 */
public final class Problem14 {

    /**
     * Private constructor.
     */
    private Problem14() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int n = 0;
        int longestChain = 0;
        int count = 0;
        long current = 0;
        int startingNumber = 0;
        for (int i = 1; i < 1_000_000; i++) {
            count = 0;
            current = i;
            startingNumber = i;
            do {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }
                count++;
            } while (current > 1);
            if (count > longestChain) {
                longestChain = count;
                n = startingNumber;
            }
        }
        System.out.println(n + " (" + (longestChain + 1) + ")");
    }
}
