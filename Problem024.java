package euler;

/**
 * Lexicographic permutations.
 *
 * @author luisramalho
 *
 */
public final class Problem024 {

    /**
     * Lexicographic permutation to check.
     */
    private static int limit = 1_000_000;

    /**
     * Recursion state.
     */
    private static boolean finished = false;

    /**
     * Prroblem024 is non-instantiable.
     */
    private Problem024() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        permutation("", "0123456789");
    }

    /**
     * Computes all permutations and displays the millionth.
     *
     * @param prefix
     *            helper holding the prefixes.
     * @param s
     *            characters to be permutated.
     */
    private static void permutation(final String prefix, final String s) {
        int n = s.length();
        if (n == 0) {
            if (--limit == 0) {
                System.out.println(prefix);
                finished = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (finished) {
                    return;
                }
                permutation(prefix + s.charAt(i),
                        s.substring(0, i) + s.substring(i + 1));
            }
        }
    }
}
