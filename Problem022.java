package euler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Names scores.
 *
 * @author luisramalho
 *
 */
public final class Problem022 {

    /**
     * Problem022 is non-instantiable.
     */
    private Problem022() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        try {
            Scanner in = new Scanner(new FileReader(
                    "src/resources/p022_names.txt"));
            String[] names = in.next().replaceAll("\"", "").split(",");
            Arrays.sort(names);
            int total = 0;
            int alphabeticalValue;
            for (int i = 0; i < names.length; i++) {
                alphabeticalValue = 0;
                for (int j = 0; j < names[i].length(); j++) {
                    alphabeticalValue += (names[i].charAt(j) - 'A' + 1);
                }
                total += ((i + 1) * alphabeticalValue);
            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
