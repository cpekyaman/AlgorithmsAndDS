package grokalg.ch01;

public final class BinarySearch<N extends Comparable<N>> {
    private final N[] inputArray;

    public BinarySearch(N[] inputArray) {
        this.inputArray = inputArray;
    }

    public int find(N item) {
        if(inputArray.length == 0) {
            return -1;
        }
        return findInRange(item, 0, inputArray.length - 1);
    }

    private int findInRange(N item, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        N candidate = inputArray[mid];

        if (candidate.equals(item)) {
            return mid;
        } else if(candidate.compareTo(item) < 0) {
            return findInRange(item, mid + 1, high);
        } else {
            return findInRange(item, low, mid - 1);
        }
    }
}
