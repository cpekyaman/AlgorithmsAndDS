package udemy.algo.advanced.spanningtree.prim;

import udemy.algo.advanced.spanningtree.common.STEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EagerPrimVertex implements NonDirectedGraphVertex<EagerPrimVertex>, Comparable<EagerPrimVertex> {
    private final String name;
    private boolean visited;
    //TODO: this is not used again ?
    private EagerPrimVertex previous;
    private STEdge<EagerPrimVertex> minimumEdge;
    private double distance = Double.POSITIVE_INFINITY;
    private List<STEdge<EagerPrimVertex>> adjacents;

    public EagerPrimVertex(String name) {
        this.name = name;
        this.adjacents = new ArrayList<>();
    }

    public void addAdjacent(STEdge<EagerPrimVertex> edge) {
        this.adjacents.add(edge);
    }

    public List<STEdge<EagerPrimVertex>> getAdjacents() {
        return adjacents;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EagerPrimVertex that = (EagerPrimVertex) o;
        return Objects.equals(name, that.name);
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        this.visited = true;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setMinimumEdge(STEdge<EagerPrimVertex> minimumEdge) {
        this.minimumEdge = minimumEdge;
    }

    public STEdge<EagerPrimVertex> getMinimumEdge() {
        return minimumEdge;
    }

    @Override
    public int compareTo(EagerPrimVertex o) {
        return Double.compare(this.distance, o.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
