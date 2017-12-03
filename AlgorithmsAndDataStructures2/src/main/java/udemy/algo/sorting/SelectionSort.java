package udemy.algo.sorting;

import java.util.Arrays;

import static udemy.algo.sorting.SortUtils.swap;

public class SelectionSort {
    private final int[] array;

    public SelectionSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for(int i = 0; i< array.length - 1; ++i) {
            int index = i;
            for(int j = i + 1; j < array.length; ++j) {
                if(array[j] < array[index]) {
                    index = j;
                }
            }

            if(index != i) {
                swap(array, i, index);
            }
        }

        System.out.printf("Sorted %s\n", Arrays.toString(array));
    }
}
