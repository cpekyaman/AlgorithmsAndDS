package udemy.algo.sorting;

public final class SortUtils {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private SortUtils() {

    }
}
