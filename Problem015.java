package euler;

/**
 * Lattice paths.
 *
 * @author luisramalho
 *
 */
public final class Problem015 {

    /**
     * Size of grid.
     */
    static final int GRID_SIZE = 20;

    /**
     * Private constructor.
     */
    private Problem015() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(binomialCoefficient(GRID_SIZE));
        System.out.println(iterativeSolution(GRID_SIZE));
    }

    /**
     * Binomial coefficient solution.
     *
     * @param size
     *            size of the grid.
     * @return lattice paths.
     */
    private static long binomialCoefficient(final int size) {
        long count = 1;
        for (int i = 0; i < size; i++) {
            count = (count * (2 * size - i)) / (i + 1);
        }
        return count;
    }

    /**
     * Iterative solution.
     *
     * @param size
     *            size of the grid.
     * @return lattice paths.
     */
    private static long iterativeSolution(final int size) {
        long[][] grid = new long[size + 1][size + 1];

        for (int i = 0; i <= size; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[size][size];
    }

}
