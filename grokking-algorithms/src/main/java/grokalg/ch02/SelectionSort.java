package grokalg.ch02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public final class SelectionSort<T extends Comparable<T>> {
    private final T[] inputArray;

    public SelectionSort(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public List<T> sorted() {
        List<T> sortedValues = new ArrayList<>(inputArray.length);
        Set<Integer> usedIndices = new HashSet<>();
        for (int i = 0; i < inputArray.length; i++) {
            int smallestIndex = findSmallest(usedIndices);
            sortedValues.add(inputArray[smallestIndex]);
        }
        return sortedValues;
    }

    // not removing any item from original array.
    // keep tracking which indices are already used so that we will skip them in later iterations.
    private int findSmallest(Set<Integer> usedIndices) {
        // start with a candidate min
        int minIndex = IntStream.range(0, inputArray.length)
                                .filter(i -> ! usedIndices.contains(i))
                                .findFirst()
                                .orElse(0);
        T min = inputArray[minIndex];

        for (int i = 1; i < inputArray.length; i++) {
            if(usedIndices.contains(i)) {
                continue;
            }

            System.out.printf("comparing %s to %s\n", inputArray[i], min);
            if(inputArray[i].compareTo(min) < 0) {
                min = inputArray[i];
                minIndex = i;
            }
        }
        usedIndices.add(minIndex);
        return minIndex;
    }
}
