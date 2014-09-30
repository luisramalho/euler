package euler;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Counting Sundays.
 *
 * @author luisramalho
 *
 */
public final class Problem019 {

    /**
     * Problem019 is non-instantiable.
     */
    private Problem019() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     * @throws ParseException
     */
    public static void main(final String[] args) {
        Calendar c = Calendar.getInstance();
        int count = 0;
        for (int i = 1901; i < 2001; i++) {
            for (int month = 0; month < 12; month++) {
                c.set(i, month, 1);
                if (c.get(Calendar.DAY_OF_WEEK) == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * A leap year occurs on any year evenly divisible by 4, but not on a
     * century unless it is divisible by 400.
     *
     * @return <code>true</code> if it's a leap year; <code>false</code>
     *         otherwise.
     */
    private static boolean leapYear(final int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

}
