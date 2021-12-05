package algo.ch01;

public final class QuickUnion {
    private final int[] data;

    public QuickUnion(int objectCount) {
        this.data = new int[objectCount];
        for (int i = 0; i < objectCount; i++) {
            data[i] = i;
        }
    }

    public boolean isConnected(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public void union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        data[aRoot] = bRoot;
    }

    private int findRoot(int oid) {
        int index = oid;
        while(index != data[index]) {
            index = data[index];
        }
        return index;
    }
}
