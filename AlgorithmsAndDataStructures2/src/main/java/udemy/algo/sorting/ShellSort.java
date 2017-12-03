package udemy.algo.sorting;

public class ShellSort {
    private final int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
            new InsertionSort(array, gap).sort();
        }
    }
}
