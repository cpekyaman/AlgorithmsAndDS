package grokalg.ch04;

import java.util.Random;

public final class QuickSort {
    private static final Random random = new Random();

    private QuickSort(){}

    public static void sort(int[] array) {
        sortRange(array, 0, array.length - 1);
    }

    private static void sortRange(int[] array, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = lomutoPartition(array, low, high);

        sortRange(array, low, pivot - 1);
        sortRange(array, pivot + 1, high);
    }

    private static int lomutoPartition(int[] array, int low, int high) {
        int pivot = random.nextInt(high - low) + low;

        // move pivot to the end for the algorithm
        swap(array, pivot, high);

        // index to track elements less than pivot
        int i = low;

        // iterate range and move elements less than pivot to left
        for (int j = low; j < high; j++) {
            if(array[j] < array[high]) {
                swap(array, i, j);
                i++;
            }
        }

        // move pivot into its expected position
        swap(array, i, high);

        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
