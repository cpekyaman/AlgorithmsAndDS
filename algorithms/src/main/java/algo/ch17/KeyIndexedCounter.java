package algo.ch17;

public final class KeyIndexedCounter {
    private final char[] array;

    // number of distinct keys (radix)
    private final int R;

    public KeyIndexedCounter(char[] array, int R) {
        this.array = array;
        this.R = R;
    }

    public char[] sort() {
        int N = array.length;
        int[] counts = new int[R + 1];

        // the relative position of the chars and how many of each we have
        for (int i = 0; i < N; i++) {
            counts[offset(i) + 1]++;
        }

        // base offsets in the sorted array for each value
        for (int i = 0; i < R; i++) {
            counts[i + 1] += counts[i];
        }

        // put values according to offsets
        char[] aux = new char[N];
        for (int i = 0; i < N; i++) {
            // increment base offset for the next repeated value of the same char
            aux[counts[offset(i)]++] = array[i];
        }

        System.arraycopy(aux, 0, array, 0, N);
        return array;
    }

    private int offset(int i) {
        return array[i] - 'a';
    }
}
