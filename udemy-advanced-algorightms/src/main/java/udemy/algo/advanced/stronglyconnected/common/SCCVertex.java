package udemy.algo.advanced.stronglyconnected.common;

public interface SCCVertex<V extends SCCVertex> {
    void addNeighbour(V vertex);
}
