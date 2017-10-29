package udemy.algo.tree.avl;

import udemy.algo.tree.TreeNode;

public class AVLNode<T extends Comparable<T>> extends TreeNode<T, AVLNode<T>> {
    private int height;

    public AVLNode(T data) {
        this(data, null, null);
    }

    public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
        super(data, left, right);
        this.height = 0;

        calculateHeight();
    }

    public void calculateHeight() {
        if(left != null && right != null) {
            this.height = Math.max(left.height, right.height) + 1;
        } else if(left != null) {
            this.height = left.height + 1;
        } else if(right != null) {
            this.height = right.height + 1;
        }
    }

    public int getHeight() {
        return height;
    }
}
