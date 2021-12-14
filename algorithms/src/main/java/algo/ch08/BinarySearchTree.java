package algo.ch08;

import java.util.LinkedList;
import java.util.Queue;

public final class BinarySearchTree<K extends Comparable<K>, V> {
    private BSTNode<K, V> root;

    public void delete(K key) {
        root = delete(key, root);
    }

    private BSTNode<K, V> delete(K key, BSTNode<K, V> current) {
        if(current == null) {
            return null;
        }

        int keyComp = key.compareTo(current.getKey());
        if(keyComp < 0) {
            current.setLeft(delete(key, current.getLeft()));
        } else if(keyComp > 0) {
            current.setRight(delete(key, current.getRight()));
        } else {
            if(current.getRight() == null) {
                return current.getLeft();
            }

            BSTNode<K, V> successor = min(current.getRight());
            successor.setRight(deleteMin(current.getRight()));
            successor.setLeft(current.getLeft());
            successor.updateSize();
            return successor;
        }

        current.updateSize();
        return current;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private BSTNode<K, V> deleteMin(BSTNode<K, V> current) {
        if(current.getLeft() == null) {
            return current.getRight();
        }
        current.setLeft(deleteMin(current.getLeft()));
        current.updateSize();
        return current;
    }

    public V max() {
        return max(root);
    }

    private V max(BSTNode<K, V> current) {
        if(current.getRight() == null) {
            return current.getValue();
        }
        return max(current.getRight());
    }

    public V min() {
        return min(root).getValue();
    }

    private BSTNode<K, V> min(BSTNode<K, V> current) {
        if(current.getLeft() == null) {
            return current;
        }
        return min(current.getLeft());
    }

    public Iterable<K> keys() {
        Queue<K> keys = new LinkedList<>();
        traverse(root, keys);
        return keys;
    }

    private void traverse(BSTNode<K, V> node, Queue<K> keys) {
        if(node == null) {
            return;
        }

        traverse(node.getLeft(), keys);
        keys.add(node.getKey());
        traverse(node.getRight(), keys);
    }

    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, BSTNode<K, V> current) {
        if(current == null) {
            return 0;
        }

        int keyComp = key.compareTo(current.getKey());
        if(keyComp < 0) {
            return rank(key, current.getLeft());
        } else if(keyComp > 0) {
            return 1 + treeSize(current.getLeft()) + rank(key, current.getRight());
        } else {
            return current.getTreeSize();
        }
    }

    private int treeSize(BSTNode<K, V> node) {
        return node == null ? 0 : node.getTreeSize();
    }

    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, BSTNode<K, V> current) {
        if(current == null) {
            return null;
        }

        int keyComp = key.compareTo(current.getKey());
        if(keyComp == 0) {
            return current.getValue();
        }

        return get(key, keyComp < 0 ? current.getLeft() : current.getRight());
    }

    public BinarySearchTree<K, V> insert(K key, V value) {
        root = insert(key, value, root);
        return this;
    }

    private BSTNode<K, V> insert(K key, V value, BSTNode<K, V> current) {
        if(current == null) {
            return new BSTNode<>(key, value);
        }

        int keyComp = key.compareTo(current.getKey());
        if(keyComp == 0) {
            current.setValue(value);
        } else if(keyComp < 0) {
            current.setLeft(insert(key, value, current.getLeft()));
        } else {
            current.setRight(insert(key, value, current.getRight()));
        }
        current.updateSize();
        return current;
    }
}
