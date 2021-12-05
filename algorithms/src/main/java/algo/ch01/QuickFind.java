package algo.ch01;

public final class QuickFind {
    private final int[] data;

    public QuickFind(int objectCount) {
        this.data = new int[objectCount];
        for (int i = 0; i < objectCount; i++) {
            data[i] = i;
        }
    }

    public boolean isConnected(int a, int b) {
        return data[a] == data[b];
    }

    public void union(int a, int b) {
        int aId = data[a];
        int bId = data[b];

        for (int i = 0; i < data.length; i++) {
            if(data[i] == aId) {
                data[i] = bId;
            }
        }
    }
}
