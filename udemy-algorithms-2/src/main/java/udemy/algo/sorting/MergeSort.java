package udemy.algo.sorting;

import java.util.Arrays;

public class MergeSort {
    private final int[] array;
    private int[] tempArray;

    public MergeSort(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
    }

    public void sort() {
        sort(0, array.length - 1);
        System.out.printf("Sorted %s\n", Arrays.toString(array));
    }

    private void merge(int low, int middle, int high) {
        for(int i = low; i < high; ++i) {
            tempArray[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while(i <= middle && j <= high) {
            if(tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                ++i;
            } else {
                array[k] = tempArray[j];
                ++j;
            }
            ++k;
        }

        while(i <= middle) {
            array[k] = tempArray[i];
            ++i;
            ++k;
        }

        while(j <= high) {
            array[k] = tempArray[j];
            ++j;
            ++k;
        }
    }

    private void sort(int low, int high) {
        if(low >= high) {
            return;
        }

        int middle = (low + high) / 2;
        sort(low, middle);
        sort(middle + 1, high);

        merge(low, middle, high);
    }
}
