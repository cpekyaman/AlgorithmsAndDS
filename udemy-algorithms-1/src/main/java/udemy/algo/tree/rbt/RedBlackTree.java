package udemy.algo.tree.rbt;

import udemy.algo.tree.AbstractTree;
import udemy.algo.tree.Tree;

public class RedBlackTree<T extends Comparable<T>> extends AbstractTree<T, RedBlackNode<T>> implements Tree<T> {
    @Override
    protected RedBlackNode<T> createNode(T data) {
        return new RedBlackNode<>(data);
    }

    @Override
    protected RedBlackNode<T> adjustSubTree(RedBlackNode<T> currentNode, T data) {
        currentNode.setParentOfChildren();

        RedBlackNode<T> parent;
        RedBlackNode<T> grandParent;

        while(currentNode != root && currentNode.isTreeConstraintViolated()) {
            parent = currentNode.getParent();
            grandParent = parent.getParent();

            if(parent == grandParent.getLeft()) {
                RedBlackNode<T> uncle = grandParent.getRight();

                // case 4
                if(uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParent.setColor(NodeColor.RED);
                    parent.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                } else {
                    if(currentNode == parent.getRight()) {
                        leftRotation(parent);
                        currentNode = parent;
                        parent = currentNode.getParent();
                    }

                    rightRotation(grandParent);
                    NodeColor parentColor = parent.getColor();
                    parent.setColor(grandParent.getColor());
                    grandParent.setColor(parentColor);
                    currentNode = parent;
                }
            } else {
                //TODO: symmetric of above case
            }
        }

        if(root.getColor() == NodeColor.RED) {
            root.setColor(NodeColor.BLACK);
        }

        return currentNode;
    }

    private RedBlackNode<T> rightRotation(RedBlackNode<T> node) {
        RedBlackNode<T> newRoot = node.getLeft();
        RedBlackNode<T> toBeLeft = newRoot.getRight();

        newRoot.setRight(node);
        node.setLeft(toBeLeft);

        //TODO: implement

        return newRoot;
    }

    private RedBlackNode<T> leftRotation(RedBlackNode<T> node) {
        RedBlackNode<T> newRoot = node.getRight();
        RedBlackNode<T> toBeRight = newRoot.getLeft();

        newRoot.setLeft(node);
        node.setRight(toBeRight);

        //TODO: implement

        return newRoot;
    }
}
