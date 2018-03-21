package udemy.algo.sorting;

import java.util.Arrays;

import static udemy.algo.sorting.SortUtils.swap;

public class InsertionSort {
    private final int[] array;
    private final int gap;

    public InsertionSort(int[] array, int gap) {
        this.array = array;
        this.gap = gap;
    }

    public InsertionSort(int[] array) {
        this(array, 1);
    }

    public void sort() {
        for (int i = gap; i < array.length; ++i) {
            int j = i;
            while (j >= gap && array[j - gap] > array[j]) {
                swap(array, j, j - gap);
                j = j - gap;
            }
        }
        System.out.printf("Sorted %s\n", Arrays.toString(array));
    }
}
