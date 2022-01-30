package algo.ch18;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

abstract class TernarySearchTrie<KEY extends CharSequence,VAL> implements Trie<KEY, VAL> {
    private Node<VAL> root;

    public TernarySearchTrie() {
        this.root = new Node<>('\u0000');
    }

    protected abstract KEY empty();

    protected abstract KEY concat(KEY prefix, char c);

    @Override
    public Iterable<KEY> keys() {
        return keysWithPrefix(this.root, empty());
    }

    @Override
    public Iterable<KEY> keysWithPrefix(KEY prefix) {
        Node<VAL> x = get(root, prefix, 0);
        if(x == null) {
            return Collections.emptyList();
        }
        Queue<KEY> keys = new LinkedList<>();
        if(x.value != null) {
            keys.offer(prefix);
        }
        collect(x.mid, prefix, keys::offer);
        return keys;
    }

    private Queue<KEY> keysWithPrefix(Node<VAL> x, KEY prefix) {
        Queue<KEY> queue = new LinkedList<>();
        collect(x, prefix, queue::offer);
        return queue;
    }

    private void collect(Node<VAL> x, KEY prefix, Consumer<KEY> collector) {
        if(x == null) {
            return;
        }
        collect(x.left, prefix, collector);
        if(x.value != null) {
            collector.accept(concat(prefix, x.c));
        }
        collect(x.mid, concat(prefix, x.c), collector);
        collect(x.right, prefix, collector);
    }

    @Override
    public void delete(KEY key) {
        put(key, null);
    }

    @Override
    public VAL get(KEY key) {
        var node = get(this.root, key, 0);
        return node != null ? node.value : null;
    }

    private Node<VAL> get(Node<VAL> x, KEY key, int d) {
        if(x == null) {
            return null;
        }

        char c = key.charAt(d);

        if(c < x.c) {
            return get(x.left, key, d);
        } else if(c > x.c) {
            return get(x.right, key, d);
        } else if(d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    @Override
    public void put(KEY key, VAL value) {
        this.root = put(root, key, value, 0);
    }

    private Node<VAL> put(Node<VAL> x, KEY key, VAL value, int d) {
        char c = key.charAt(d);
        if(x == null) {
            x = new Node<>(c);
        }

        if(c < x.c) {
            x.left = put(x.left, key, value, d);
        } else if(c > x.c) {
            x.right = put(x.right, key, value, d);
        } else if(d < key.length() - 1) {
            x.mid = put(x.mid, key, value, d + 1);
        } else {
            x.value = value;
        }
        return x;
    }

    static final class Node<V> {
        private final char c;
        private V value;
        private Node<V> left, mid, right;

        Node(char c) {
            this.c = c;
        }

        Node(char c, V value) {
            this.c = c;
            this.value = value;
        }
    }
}
