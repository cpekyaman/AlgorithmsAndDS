package algo.ch05;

public final class MergeSort<T extends Comparable<T>> {
    private final T[] array;
    @SuppressWarnings("raw")
    private final Comparable[] auxArray;

    public MergeSort(T[] array) {
        this.array = array;
        // generic array creation is ugly
        this.auxArray = new Comparable[array.length];
    }

    public T[] sort() {
        this.sort(0, array.length - 1);
        return array;
    }

    private void sort(int low, int high) {
        if(high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(low, mid);
        sort(mid + 1, high);
        merge(low, mid, high);
    }

    @SuppressWarnings("unchecked")
    private void merge(int low, int mid, int high) {
        System.arraycopy(array, low, auxArray, low, high - low + 1);

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if(i > mid) {
                array[k] = (T) auxArray[j++];
            } else if(j > high) {
                array[k] = (T) auxArray[i++];
            } else if(auxArray[i].compareTo(auxArray[j]) < 0) {
                array[k] = (T) auxArray[i++];
            } else {
                array[k] = (T) auxArray[j++];
            }
        }
    }
}
