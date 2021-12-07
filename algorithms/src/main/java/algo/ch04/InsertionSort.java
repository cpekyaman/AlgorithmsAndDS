package algo.ch04;

import algo.util.SortUtils;

public final class InsertionSort<T extends Comparable<T>> {
    private final T[] array;

    public InsertionSort(T[] array) {
        this.array = array;
    }

    public T[] sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j].compareTo(array[j - 1]) < 0) {
                    SortUtils.swap(array, j, j - 1);
                }
            }
        }
        return array;
    }
}
