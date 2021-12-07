package algo.ch04;

import algo.util.SortUtils;

import java.util.Random;

public final class Shuffler<T extends Comparable<T>> {
    private final T[] array;

    public Shuffler(T[] array) {
        this.array = array;
    }

    public T[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int r = random.nextInt(i + 1);
            SortUtils.swap(array, i, r);
        }
        return array;
    }
}
