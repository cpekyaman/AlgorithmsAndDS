package udemy.algo.tree.bst;

import udemy.algo.tree.TreeNode;

public class BSTNode<T extends Comparable<T>> extends TreeNode<T, BSTNode<T>> {

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        super(data, left, right);
    }

    public BSTNode(T data) {
        super(data);
    }

}
