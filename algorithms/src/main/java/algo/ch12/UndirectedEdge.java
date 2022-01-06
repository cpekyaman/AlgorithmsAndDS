package algo.ch12;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.Objects;

public final class UndirectedEdge extends Edge {

    public UndirectedEdge(Vertex V, Vertex W) {
        super(V, W);
    }

    public UndirectedEdge(Vertex V, Vertex W, int weight) {
        super(V, W, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedEdge edge = (UndirectedEdge) o;
        return (V.equals(edge.V) && W.equals(edge.W))
                || (V.equals(edge.W) && W.equals(edge.V));
    }

    @Override
    public int hashCode() {
        return V.compareTo(W) < 0 ? Objects.hash(V, W) : Objects.hash(W, V);
    }
}
