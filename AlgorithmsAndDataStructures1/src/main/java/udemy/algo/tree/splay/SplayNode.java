package udemy.algo.tree.splay;

import udemy.algo.tree.TreeNode;
import udemy.algo.tree.rbt.RedBlackNode;

public class SplayNode<T extends Comparable<T>> extends TreeNode<T, SplayNode<T>> {
    private SplayNode<T> parent;

    public SplayNode(T data) {
        super(data);
    }

    public SplayNode(T data, SplayNode<T> left, SplayNode<T> right) {
        super(data, left, right);
    }

    public SplayNode<T> getParent() {
        return parent;
    }

    public void setParent(SplayNode<T> parent) {
        this.parent = parent;
    }

    public SplayNode<T> getGrandParent() {
        if(parent != null) {
            return parent.getParent();
        } else {
            return null;
        }
    }
}
