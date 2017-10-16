package udemy.algo.tree.avl;

import udemy.algo.tree.AbstractTree;
import udemy.algo.tree.Tree;

public class AVLTree<T extends Comparable<T>> extends AbstractTree<T, AVLNode<T>> implements Tree<T> {

    @Override
    protected AVLNode<T> createNode(T data) {
        return new AVLNode<>(data);
    }

    @Override
    public void delete(T data) {
        //TODO: implement
    }

    @Override
    protected AVLNode<T> adjustSubTree(AVLNode<T> currentNode, T data) {
        currentNode.calculateHeight();
        int balance = getBalance(currentNode);

        if(balance > 1) {
            // case 1 => left-right heavy
            // case 2 => doubly-left heavy
            if(currentNode.getLeft().isRightCandidate(data)) {
                currentNode.setLeft(leftRotation(currentNode.getLeft()));
            }
            return rightRotation(currentNode);
        } else if(balance < -1) {
            // case 1 => right-left heavy
            // case 2 => doubly-right heavy
            if(currentNode.getRight().isLeftCandidate(data)) {
                currentNode.setRight(rightRotation(currentNode.getRight()));
            }
            return leftRotation(currentNode);
        }

        return currentNode;
    }

    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.getHeight();
    }

    private int getBalance(AVLNode<T> node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getLeft();
        AVLNode<T> toBeLeft = newRoot.getRight();

        newRoot.setRight(node);
        node.setLeft(toBeLeft);

        node.calculateHeight();
        newRoot.calculateHeight();

        return newRoot;
    }

    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getRight();
        AVLNode<T> toBeRight = newRoot.getLeft();

        newRoot.setLeft(node);
        node.setRight(toBeRight);

        node.calculateHeight();
        newRoot.calculateHeight();

        return newRoot;
    }
}
