package udemy.algo.hashtable;

public interface CollisionStrategy<K, V> {
    V get(K key);

    void put(K key, V value);

    V remove(K key);
}
