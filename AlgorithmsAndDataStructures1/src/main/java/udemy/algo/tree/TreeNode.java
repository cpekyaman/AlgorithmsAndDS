package udemy.algo.tree;

public abstract class TreeNode<T extends Comparable<T>, E extends TreeNode<T, E>> {
    protected T data;
    protected E left;
    protected E right;

    protected TreeNode(T data) {
        this.data = data;
    }

    protected TreeNode(T data, E left, E right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public E getRight() {
        return right;
    }

    public void setRight(E right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public boolean isLeftCandidate(T data) {
        return this.data.compareTo(data) > 0;
    }

    public boolean isRightCandidate(T data) {
        return this.data.compareTo(data) < 0;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
