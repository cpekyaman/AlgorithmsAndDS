package algo.ch09;

import java.util.function.Consumer;

public final class RedBlackTree<K extends Comparable<K>, V> {

    private RBTNode<K, V> root;

    public RedBlackTree<K, V> insert(K key, V value) {
        this.root = insert(this.root, key, value);
        this.root.fixAsRoot();
        return this;
    }

    private RBTNode<K, V> insert(RBTNode<K, V> current, K key, V value) {
        if(current == null) {
            return new RBTNode<>(key, value);
        }

        int keyComp = key.compareTo(current.getKey());
        if(keyComp < 0) {
            current.setLeft(insert(current.getLeft(), key, value));
        } else if(keyComp > 0) {
            current.setRight(insert(current.getRight(), key, value));
        } else {
            current.setValue(value);
        }

        return current.fixBalance();
    }

    public void traverse(Consumer<RBTNode<K, V>> handler) {
        traverse(root, handler);
    }

    private void traverse(RBTNode<K, V> node, Consumer<RBTNode<K, V>> handler) {
        if(node == null) {
            return;
        }

        traverse(node.getLeft(), handler);
        handler.accept(node);
        traverse(node.getRight(), handler);
    }
}
