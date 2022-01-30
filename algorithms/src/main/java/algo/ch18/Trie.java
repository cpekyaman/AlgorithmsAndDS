package algo.ch18;

public interface Trie<KEY extends CharSequence, VAL> {

    default boolean contains(KEY key) {
        return get(key) != null;
    }

    Iterable<KEY> keys();

    Iterable<KEY> keysWithPrefix(KEY prefix);

    void delete(KEY key);

    VAL get(KEY key);

    void put(KEY key, VAL value);
}
