package udemy.algo.sorting;

import java.util.Arrays;

import static udemy.algo.sorting.SortUtils.swap;

public class BogoSort {
    private final int[] array;

    public BogoSort(int[] array) {
        this.array = array;
    }

    private boolean isSorted() {
        for(int i = 0; i < array.length - 1; ++i) {
            if(array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }



    // Fisher-Yates Algorithm
    private void shuffle() {
        for(int i = array.length - 1; i >= 0; --i) {
            int j = (int) (Math.random() * i);
            swap(array, i, j);
        }
    }

    public void sort() {
        int loopCounter = 0;
        while(! isSorted()) {
            ++loopCounter;
            shuffle();
        }
        System.out.printf("Sorted in %d iterations \n", loopCounter);
        System.out.println(Arrays.toString(array));
    }
}
