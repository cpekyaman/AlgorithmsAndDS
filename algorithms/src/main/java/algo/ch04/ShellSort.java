package algo.ch04;

import algo.util.SortUtils;

public class ShellSort<T extends Comparable<T>> {
    private final T[] array;

    public ShellSort(T[] array) {
        this.array = array;
    }

    public T[] sort() {
        int h = 1;
        while(h < array.length / 3) {
            h = 3 * h + 1;
        }

        while(h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j].compareTo(array[j - h]) < 0 ; j -= h) {
                    SortUtils.swap(array, j, j-h);
                }
            }
            h = h / 3;
        }

        return array;
    }


}
