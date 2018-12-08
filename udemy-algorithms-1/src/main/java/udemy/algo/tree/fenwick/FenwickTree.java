package udemy.algo.tree.fenwick;

public class FenwickTree {
    private final int[] tree;

    public FenwickTree(int[] array) {
        this.tree = new int[array.length + 1];
        build(array);
    }

    private void build(int[] array) {
        for(int i=1; i<= array.length; ++i) {
            update(i, array[i - 1]);
        }
    }

    private void update(int index, int number) {
        while(index < this.tree.length) {
            this.tree[index] += number;
            index = next(index);
        }
    }

    private int next(int index) {
        return index + (index & -index);
    }

    private int parent(int index) {
        return index - (index & -index);
    }

    public int rangeSum(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    public int sum(int index) {
        int position = index + 1;

        int sum = 0;
        while(position > 0) {
            sum = sum + this.tree[position];
            position = parent(position);
        }
        return sum;
    }
}
