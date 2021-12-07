package algo.ch04;

import algo.util.SortUtils;

public final class SelectionSort<T extends Comparable<T>> {
    private final T[] array;

    public SelectionSort(T[] array) {
        this.array = array;
    }

    public T[] sort() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[i].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            SortUtils.swap(array, i, minIndex);
        }
        return array;
    }
}
