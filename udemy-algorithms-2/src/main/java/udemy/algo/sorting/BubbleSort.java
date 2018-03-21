package udemy.algo.sorting;

import java.util.Arrays;

import static udemy.algo.sorting.SortUtils.swap;

public class BubbleSort {
    private final int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        System.out.printf("Sorting %s\n", Arrays.toString(array));

        for(int i = 0; i < array.length - 1; ++i) {
            for(int j = 0; j < array.length - i - 1; ++j) {
                if(array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }

        System.out.printf("Sorted %s\n", Arrays.toString(array));
    }
}
