package udemy.algo.tree.splay;

import udemy.algo.tree.AbstractTree;
import udemy.algo.tree.Tree;

public class SplayTree<T extends Comparable<T>> extends AbstractTree<T, SplayNode<T>> implements Tree<T> {
    private int size = 0;

    @Override
    public void insert(T data) {
        SplayNode<T> temp = this.root;
        SplayNode<T> parent = null;

        while(temp != null) {
            parent = temp;
            if(temp.isLeftCandidate(data)) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }

        temp = new SplayNode<T>(data);
        temp.setParent(parent);

        if(parent == null) {
            this.root = temp;
        } else if(parent.isLeftCandidate(temp.getData())) {
            parent.setLeft(temp);
        } else {
            parent.setRight(temp);
        }

        ++size;
        adjustSubTree(temp, data);
    }

    @Override
    protected SplayNode<T> createNode(T data) {
        return new SplayNode<>(data);
    }

    @Override
    protected SplayNode<T> adjustSubTree(SplayNode<T> currentNode, T data) {
        while(currentNode.getParent() != null) {
            if(isZig(currentNode)) {
                if(currentNode.getParent().getLeft() == currentNode) {
                    rightRotation(currentNode.getParent());
                } else {
                    leftRotation(currentNode.getParent());
                }
            } else if(isLeftZigZig(currentNode)) {
                rightRotation(currentNode.getGrandParent());
                rightRotation(currentNode.getParent());
            } else if(isRightZigZig(currentNode)) {
                leftRotation(currentNode.getGrandParent());
                leftRotation(currentNode.getParent());
            } else if(isLeftZigZag(currentNode)) {
                leftRotation(currentNode.getParent());
                rightRotation(currentNode.getParent());
            } else if(isRightZigZag(currentNode)) {
                rightRotation(currentNode.getParent());
                leftRotation(currentNode.getParent());
            }
        }
        return null;
    }

    private boolean isZig(SplayNode<T> node) {
        return node.getParent().getParent() == null;
    }

    private boolean isLeftZigZig(SplayNode<T> node) {
        return node.getParent().getLeft() == node && node.getGrandParent().getLeft() == node.getParent();
    }

    private boolean isLeftZigZag(SplayNode<T> node) {
        return node.getParent().getRight() == node && node.getGrandParent().getLeft() == node.getParent();
    }

    private boolean isRightZigZag(SplayNode<T> node) {
        return node.getParent().getLeft() == node && node.getGrandParent().getRight() == node.getParent();
    }

    private boolean isRightZigZig(SplayNode<T> node) {
        return node.getParent().getRight() == node && node.getGrandParent().getRight() == node.getParent();
    }

    private SplayNode<T> rightRotation(SplayNode<T> node) {
        //TODO: implement
        return node;
    }

    private SplayNode<T> leftRotation(SplayNode<T> node) {
        //TODO: implement
        return node;
    }
}
