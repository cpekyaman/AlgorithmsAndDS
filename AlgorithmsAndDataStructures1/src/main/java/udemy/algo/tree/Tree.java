package udemy.algo.tree;

import java.util.function.Consumer;

public interface Tree<T extends Comparable<T>> {
    void traverse(Consumer<T> c);

    void insert(T data);

    void delete(T data);

    T getMax();

    T getMin();
}
