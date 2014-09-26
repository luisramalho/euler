package euler;

/**
 * Number letter counts.
 *
 * @author luisramalho
 *
 */

public final class Problem017 {

    /**
     * "Tens" names from 10 to 90.
     */
    private static final String[] TENS = { "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };

    /**
     * Numbers' names from 1 to 19.
     */
    private static final String[] NUMBERS = { "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };

    /**
     * Problem017 is non-instantiable.
     */
    private Problem017() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int letters = 0;

        // From 1 to 19
        for (int i = 1; i < NUMBERS.length + 1; i++) {
            letters += NUMBERS[i - 1].length();
        }

        // From 20 to 99
        for (int i = 0; i < TENS.length; i++) {
            letters += TENS[i].length();
            for (int j = 0; j < 9; j++) {
                letters += TENS[i].length() + NUMBERS[j].length();
            }
        }

        int lettersTo99 = letters;

        // From 100 to 999
        for (int i = 0; i < 9; i++) {
            letters += NUMBERS[i].length() + "hundred".length();
            letters += NUMBERS[i].length() * 99 + "hundred".length() * 99
                    + "and".length() * 99 + lettersTo99;
        }

        letters += "one".length() + "thousand".length();

        System.out.println(letters);
    }

}
