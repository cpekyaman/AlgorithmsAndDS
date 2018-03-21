package udemy.algo.hashtable;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.stream.IntStream;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 128;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private K[] keys;
    private V[] values;
    private int numberOfItems;
    private int capacity;
    private double loadFactor;

    private final CollisionStrategy<K,V> strategy;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.numberOfItems = 0;
        this.keys = (K[])Array.newInstance(getType(0), capacity);
        this.values = (V[])Array.newInstance(getType(1), capacity);
        this.strategy = new LinearProbing();
    }

    private Class getType(int typeDefIndex) {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[typeDefIndex];
    }

    public V get(K key) {
        if(key == null) {
            return null;
        }

        return strategy.get(key);
    }

    public void put(K key, V value) {
        if(key == null || value == null) {
            return;
        }

        if(this.numberOfItems >= this.capacity * loadFactor) {
            resize(2 * this.capacity);
        }

        strategy.put(key, value);
    }

    private void resize(int newCapacity) {
        HashTable<K,V> resized = new HashTable<>(newCapacity);

        IntStream.range(0, this.capacity)
                .filter(i -> keys[i] != null)
                .forEach(i -> resized.put(keys[i], values[i]));

        this.keys = resized.keys;
        this.values = resized.values;
        this.capacity = resized.numberOfItems;
        this.numberOfItems = resized.numberOfItems;
    }

    public V remove(K key) {
        V val = strategy.remove(key);
        if(val != null) {
            shift(hash(key));
        }
        if(numberOfItems <= capacity / 3) {
            resize(capacity / 2);
        }
        return val;
    }

    private void shift(int index) {
        //TODO: remove and reinsert items after index
    }

    public int size() {
        return this.numberOfItems;
    }

    public boolean isEmpty() {
        return this.numberOfItems == 0;
    }

    private int hash(K key) {
        return key.hashCode() % this.capacity;
    }

    class LinearProbing implements CollisionStrategy<K, V> {
        @Override
        public V get(K key) {
            int index = hash(key);

            while(keys[index] != null) {
                if (keys[index].equals(key)) {
                    return values[index];
                }
                index = (index + 1) % capacity;
            }

            return null;
        }

        @Override
        public void put(K key, V value) {
            int index = hash(key);

            while(keys[index] != null) {
                if(keys[index].equals(key)) {
                    values[index] = value;
                    return;
                }
                index = (index + 1) % capacity;
            }

            keys[index] = key;
            values[index] = value;
            numberOfItems++;
        }

        @Override
        public V remove(K key) {
            if(key == null) {
                return null;
            }

            int index = hash(key);
            while(! keys[index].equals(key)) {
                index = (index + 1) % capacity;
            }

            keys[index] = null;
            V val = values[index];
            values[index] = null;
            numberOfItems--;
            return val;
        }
    }
}
