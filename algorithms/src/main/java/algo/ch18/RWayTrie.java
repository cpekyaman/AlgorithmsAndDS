package algo.ch18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

abstract class RWayTrie<KEY extends CharSequence, VAL> implements Trie<KEY,VAL> {
    private final int R;
    private Node root;

    public RWayTrie(int r) {
        this.R = r;
        this.root = new Node(null, r);
    }

    protected abstract KEY empty();

    protected abstract KEY concat(KEY prefix, char c);

    @Override
    public Iterable<KEY> keys() {
        return keysWithPrefix(this.root, empty());
    }

    @Override
    public Iterable<KEY> keysWithPrefix(KEY prefix) {
        return keysWithPrefix(get(root, prefix, 0), prefix);
    }

    private Iterable<KEY> keysWithPrefix(Node x, KEY prefix) {
        Queue<KEY> queue = new LinkedList<>();
        collect(x, prefix, queue::offer);
        return queue;
    }

    private void collect(Node x, KEY prefix, Consumer<KEY> collector) {
        if(x == null) {
            return;
        }
        if(x.value != null) {
            collector.accept(prefix);
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], concat(prefix, c), collector);
        }
    }

    @Override
    public void delete(KEY key) {
        this.root = delete(root, key, 0);
    }

    private Node delete(Node x, KEY key, int d) {
        if(x == null) {
            return null;
        }

        if(key.length() == d) {
            x.value = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if(x.value != null) {
            return x;
        }

        for(Node xc : x.next) {
            if(xc != null) {
                return x;
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public VAL get(KEY key) {
        Node found = get(root, key, 0);
        return found != null ? (VAL) found.value : null;
    }

    private Node get(Node x, KEY key, int d) {
        if(x == null) {
            return null;
        }
        if(key.length() == d) {
            return x;
        }
        return get(x.next[key.charAt(d)], key, d + 1);
    }

    @Override
    public void put(KEY key, VAL value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, KEY key, VAL value, int d) {
        if(x == null) {
            x = node(null);
        }

        if(d == key.length()) {
            x.value = value;
            return x;
        }

        char ch = key.charAt(d);
        x.next[ch] = put(x.next[ch], key, value, d+1);
        return x;
    }

    private Node node(Object value) {
        return new Node(value, this.R);
    }

    private static class Node {
        private Object value;
        private final Node[] next;

        private Node(Object value, int r) {
            this.value = value;
            this.next = new Node[r];
        }
    }
}
