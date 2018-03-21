package udemy.algo.advanced.graph;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class BaseVertex<T, E extends BaseVertex<T, E>> {
    private final T data;
    private final Set<E> neighbours;
    private boolean visited;

    public BaseVertex(T data) {
        this.data = data;
        this.neighbours = new LinkedHashSet<>();
    }

    public void addNeighbour(E vertex) {
        this.neighbours.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseVertex vertex = (BaseVertex) o;

        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return 17 + 11 * data.hashCode();
    }

    public Set<E> getNeighbours() {
        return Collections.unmodifiableSet(neighbours);
    }

    public boolean isVisited() {
        return visited;
    }

    public void mark() {
        this.visited = true;
    }

    public void visit() {
        mark();
        System.out.printf("%s ", this.data);
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
