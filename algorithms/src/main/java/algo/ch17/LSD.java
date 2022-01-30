package algo.ch17;

public final class LSD {
    private final String[] array;

    public LSD(String[] array) {
        this.array = array;
    }

    public String[] sort() {
        // fixed length strings
        final int W = array[0].length();
        final int N = array.length;
        // all ascii stuff
        final int R = 256;

        String[] aux = new String[N];

        // keyIndexedCount for each char from right to left
        for (int i = W - 1; i >=0 ; i--) {
            keyIndexedCount(aux, N, R, i);
        }

        return array;
    }

    private void keyIndexedCount(String[] aux, int N, int R, int keyPos) {
        int[] counts = new int[R + 1];
        for (int i = 0; i < N; i++) {
            counts[array[i].charAt(keyPos) + 1]++;
        }

        for (int i = 0; i < R; i++) {
            counts[i + 1] += counts[i];
        }

        for (int i = 0; i < N; i++) {
            aux[counts[array[i].charAt(keyPos)]++] = array[i];
        }

        System.arraycopy(aux, 0, array, 0, N);
    }
}
