package udemy.algo.sorting;

import java.util.Arrays;

import static udemy.algo.sorting.SortUtils.swap;

public class QuickSort {
    private final int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    private int partition(int low, int high) {
        int pivot = (low + high) / 2;
        swap(array, pivot, high);

        int i = low;

        for(int j = low; j < high; ++j) {
            if(array[j] < array[high]) {
                swap(array, j, i);
                ++i;
            }
        }

        swap(array, i, high);
        return i;
    }

    public void sort() {
        sort(0, array.length - 1);
        System.out.printf("Sorted %s\n", Arrays.toString(array));
    }

    private void sort(int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = partition(low, high);

        sort(low, pivot - 1);
        sort(pivot + 1, high);
    }
}
