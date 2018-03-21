package udemy.algo.advanced.spanningtree.prim;

import udemy.algo.advanced.spanningtree.common.STEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LazyPrimVertex implements NonDirectedGraphVertex<LazyPrimVertex> {
    private final String name;
    //TODO: why they are not used ?
    private boolean visited;
    private LazyPrimVertex previous;
    private List<STEdge<LazyPrimVertex>> adjacents;

    public LazyPrimVertex(String name) {
        this.name = name;
        this.adjacents = new ArrayList<>();
    }

    public void addAdjacent(STEdge<LazyPrimVertex> edge) {
        this.adjacents.add(edge);
    }

    public List<STEdge<LazyPrimVertex>> getAdjacents() {
        return adjacents;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LazyPrimVertex that = (LazyPrimVertex) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
