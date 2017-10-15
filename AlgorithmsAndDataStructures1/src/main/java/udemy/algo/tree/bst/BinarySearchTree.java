package udemy.algo.tree.bst;

import udemy.algo.tree.AbstractTree;
import udemy.algo.tree.Tree;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractTree<T, BSTNode<T>> implements Tree<T> {
    private BSTNode<T> tree;

    @Override
    protected BSTNode<T> createNode(T data) {
        return new BSTNode<>(data);
    }

    @Override
    protected BSTNode<T> checkSubtree(BSTNode<T> currentNode, T data) {
        return currentNode;
    }

}
