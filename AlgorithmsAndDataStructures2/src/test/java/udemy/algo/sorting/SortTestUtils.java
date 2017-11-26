package udemy.algo.sorting;

import java.util.Random;

public class SortTestUtils {
    public static int[] randomArray10() {
        return new Random().ints(10, -50, 50).toArray();
    }

    public static int[] randomPositiveArray10() {
        return new Random().ints(10, 10, 50).toArray();
    }

    private SortTestUtils() {

    }
}
