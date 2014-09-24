package euler;

/**
 * Longest Collatz sequence.
 *
 * @author luisramalho
 *
 */
public final class Problem014 {

    /**
     * Highest number to check.
     */
    static final int LIMIT = 1_000_000;

    /**
     * Private constructor.
     */
    private Problem014() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        long start = System.currentTimeMillis();
        long current = 0;
        int longestChain = 0;
        int chainLength = 0;
        int startingNumber = 0;
        boolean[] checked = new boolean[LIMIT];
        int[] chainsLength = new int[LIMIT];
        int tempStartingNumber = 0;
        for (int i = 1; i < LIMIT; i++) {
            current = i;
            chainLength = 0;
            tempStartingNumber = i;
            do {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }
                chainLength++;

                // Caching and checking for lower chains already solved.
                if (current < tempStartingNumber && checked[(int) current]) {
                    chainLength += chainsLength[(int) current];
                    chainsLength[tempStartingNumber] = chainLength;
                    current = 1;
                }
            } while (current > 1);

            checked[tempStartingNumber] = true;

            if (chainLength > longestChain) {
                longestChain = chainLength;
                startingNumber = tempStartingNumber;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(startingNumber + " (" + (longestChain + 1) + ")");
        System.out.println("Took: " + (end - start) + "ms");
    }
}
