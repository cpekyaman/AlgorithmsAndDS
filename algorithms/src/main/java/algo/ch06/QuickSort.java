package algo.ch06;

import algo.ch04.Shuffler;
import algo.util.SortUtils;

public final class QuickSort<T extends Comparable<T>> {

    private final T[] array;

    public QuickSort(T[] array) {
        this.array = array;
    }

    public T[] sort() {
        // in place shuffle
        new Shuffler<>(array).shuffle();

        sort(0, array.length - 1);
        return array;
    }

    private void sort(int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = partition(low, high);
        sort(low, mid - 1);
        sort(mid + 1, high);
    }

    private int partition(int low, int high) {
        // move two pointers in opposite directions until they cross.
        // and swap them to have left side of pivot < pivot < right side of pivot.
        int i = low, j = high + 1;
        while(true) {
            do {
                i++;
            } while(i < high && array[i].compareTo(array[low]) < 0);

            do {
                j--;
            } while(j > low && array[j].compareTo(array[low]) > 0);

            if(i >= j) {
                break;
            }
            SortUtils.swap(array, i, j);
        }

        // put our pivot element in its place
        SortUtils.swap(array, low, j);

        return j;
    }
}
