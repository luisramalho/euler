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
        long count = 1;
        for (int i = 0; i < GRID_SIZE; i++) {
            count = (count * (2 * GRID_SIZE - i)) / (i + 1);
        }
        System.out.println(count);
    }

}
