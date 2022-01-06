package algo.ch13;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.Objects;

public final class DirectedEdge extends Edge {

    public DirectedEdge(Vertex V, Vertex W) {
        super(V, W);
    }

    public DirectedEdge(Vertex V, Vertex W, int weight) {
        super(V, W, weight);
    }

    public Vertex from() {
        return V;
    }

    public Vertex to() {
        return W;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedEdge edge = (DirectedEdge) o;
        return V.equals(edge.V) && W.equals(edge.W);
    }

    @Override
    public int hashCode() {
        return Objects.hash(V, W);
    }
}
