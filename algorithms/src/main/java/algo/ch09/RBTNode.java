package algo.ch09;

public final class RBTNode<K extends Comparable<K>, V> {
    enum Color {
        Red, Black
    }

    private final K key;
    private V value;
    private RBTNode<K, V> left, right;
    private Color color;

    // inserting a new node as red by default
    public RBTNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.color = Color.Red;
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

    public RBTNode<K, V> getLeft() {
        return left;
    }

    public RBTNode<K, V> getRight() {
        return right;
    }

    public void setLeft(RBTNode<K, V> left) {
        this.left = left;
    }

    public void setRight(RBTNode<K, V> right) {
        this.right = right;
    }

    public boolean isRed() {
        return this.color == Color.Red;
    }

    public RBTNode<K, V> fixBalance() {
        // right leaning red, rotateLeft
        // two red links to a node, rotateRight
        // both children red, flip colors
        if(isRed(right) && !isRed(left)) {
            return this.rotateLeft();
        } else if(isRed(left) && isRed(left.left)) {
            return this.rotateRight();
        }

        if(isRed(left) && isRed(right)) {
            this.flip();
        }
        return this;
    }

    private void flip() {
        this.left.color = Color.Black;
        this.right.color = Color.Black;
        this.color = Color.Red;
    }

    private boolean isRed(RBTNode<K, V> child) {
        return child != null && child.isRed();
    }

    public RBTNode<K, V> rotateLeft() {
        if(! isRed(right)) {
            return this;
        }

        RBTNode<K, V> rotated = this.right;
        this.right = rotated.left;
        rotated.left = this;
        rotated.color = rotated.left.color;
        rotated.left.color = Color.Red;

        return rotated;
    }

    public RBTNode<K, V> rotateRight() {
        if(! isRed(left)) {
            return this;
        }

        RBTNode<K, V> rotated = this.left;
        this.left = rotated.right;
        rotated.right = this;
        rotated.color = rotated.right.color;
        rotated.right.color = Color.Red;

        return rotated;
    }

    public void fixAsRoot() {
        // root is always black
        this.color = Color.Black;
    }

    @Override
    public String toString() {
        return "RBTNode{" + "key=" + key + ", value=" + value + ", color=" + color + '}';
    }
}
