package udemy.algo.tree.rbt;

import udemy.algo.tree.TreeNode;

public class RedBlackNode<T extends Comparable<T>> extends TreeNode<T, RedBlackNode<T>> {
    private NodeColor color;
    private RedBlackNode<T> parent;

    public RedBlackNode(T data) {
        this(data, null, null);
    }

    public RedBlackNode(T data, RedBlackNode<T> left, RedBlackNode<T> right) {
        super(data, left, right);
        this.color = NodeColor.RED;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public void setParentOfChildren() {
        if(this.getLeft() != null) {
            this.getLeft().setParent(this);
        }
        if(this.getRight() != null) {
            this.getRight().setParent(this);
        }
    }

    public boolean isTreeConstraintViolated() {
        return  this.color != NodeColor.BLACK && this.getParent().color == NodeColor.RED;
    }
}
