package udemy.algo.sorting;

import java.util.Random;

public class SortTestUtils {
    public static int[] randomArray10() {
        return randomArray(10);
    }

    public static int[] randomArray20() {
        return randomArray(20);
    }

    private static int[] randomArray(int size) {
        return new Random().ints(size, -50, 50).toArray();
    }

    public static int[] randomPositiveArray10() {
        return new Random().ints(10, 10, 50).toArray();
    }

    private SortTestUtils() {

    }
}
