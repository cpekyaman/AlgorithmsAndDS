package algo.ch01;

public class WeightedQuickUnion {
    private final int[] data;
    private final int[] treeSz;

    public WeightedQuickUnion(int objectCount) {
        this.data = new int[objectCount];
        this.treeSz = new int[objectCount];
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

        if(treeSz[aRoot] > treeSz[bRoot]) {
            data[bRoot] = aRoot;
            treeSz[aRoot] += treeSz[bRoot];
        } else {
            data[aRoot] = bRoot;
            treeSz[bRoot] += treeSz[aRoot];
        }
    }

    private int findRoot(int oid) {
        int index = oid;
        while(index != data[index]) {
            // path compression
            // data[index] = data[data[index]];
            index = data[index];
        }

        // path compression (point all intermediate nodes to root)
        int root = index;
        index = oid;
        while(data[index] != root) {
            // one level up
            index = data[index];
            // point current level to root
            data[index] = root;
        }

        return root;
    }
}
