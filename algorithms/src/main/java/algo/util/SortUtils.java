package algo.util;

public final class SortUtils {

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private SortUtils() {
    }
}
