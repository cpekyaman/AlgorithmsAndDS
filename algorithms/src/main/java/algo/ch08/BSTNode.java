package algo.ch08;

public final class BSTNode<K extends Comparable<K>, V> {
    private final K key;
    private V value;
    private BSTNode<K, V> left, right;
    private int treeSize;

    public BSTNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BSTNode<K, V> getLeft() {
        return left;
    }

    public BSTNode<K, V> getRight() {
        return right;
    }

    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }

    public void updateSize() {
        this.treeSize = 1 + size(this.left) + size(this.right);
    }

    private int size(BSTNode<K, V> subtree) {
        if(subtree == null) {
            return 0;
        }
        return subtree.treeSize;
    }

    public int getTreeSize() {
        return treeSize;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
