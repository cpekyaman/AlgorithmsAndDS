package udemy.algo.tree;

import java.util.function.Consumer;

public abstract class AbstractTree<T extends Comparable<T>, E extends TreeNode<T, E>> implements Tree<T> {
    private E root;

    @Override
    public void traverse(Consumer<T> c) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root, c);
    }

    @Override
    public void delete(T data) {
        if(root == null) {
            return;
        }

        delete(root, data);
    }

    private E delete(E current, T data){
        if(current == null) {
            return null;
        } else if(current.isLeftCandidate(data)) {
            current.setLeft(delete(current.getLeft(), data));
        } else if(current.isRightCandidate(data)) {
            current.setRight(delete(current.getRight(), data));
        } else {
            if(current.isLeaf()) {
                return null;
            } else if(current.getLeft() == null) {
                return current.getRight();
            } else if(current.getRight() == null) {
                return current.getLeft();
            } else {
                E predecessor = findRightMost(current.getLeft());
                current.setData(predecessor.getData());
                current.setLeft(delete(current.getLeft(), predecessor.getData()));
            }
        }

        return checkSubtree(current, data);
    }

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    protected abstract E createNode(T data);

    protected abstract E checkSubtree(E currentNode, T data);

    private E insert(E currentNode, T data) {
        if(currentNode == null) {
            return createNode(data);
        } else if(currentNode.isLeftCandidate(data)) {
            currentNode.setLeft(insert(currentNode.getLeft(), data));
        } else if(currentNode.isRightCandidate(data)) {
            currentNode.setRight(insert(currentNode.getRight(), data));
        }

        return checkSubtree(currentNode, data);
    }

    private void inOrderTraversal(E root, Consumer<T> c) {
        if(root.getLeft() != null) {
            inOrderTraversal(root.getLeft(), c);
        }

        c.accept(root.getData());

        if(root.getRight() != null) {
            inOrderTraversal(root.getRight(), c);
        }
    }

    @Override
    public T getMax() {
        if(root == null) {
            return null;
        }
        return findRightMost(root).getData();
    }

    private E findRightMost(E root) {
        if(root.getRight() == null) {
            return root;
        }
        return findRightMost(root.getRight());
    }

    @Override
    public T getMin() {
        if(root == null) {
            return null;
        }
        return findLeftMost(root).getData();
    }

    private E findLeftMost(E root) {
        if(root.getLeft() == null) {
            return root;
        }
        return findLeftMost(root.getLeft());
    }
}
