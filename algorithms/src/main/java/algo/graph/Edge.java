package algo.graph;

import java.util.Comparator;
import java.util.Objects;

// sort of an undirected edge as edge(a,b) == edge(b,a).
// directed-ness shall be managed on adjacent lists of vertices.
public final class Edge implements Comparable<Edge> {
    private final Vertex V;
    private final Vertex W;
    private final int weight;

    public Edge(Vertex V, Vertex W) {
        this(V, W, 1);
    }

    public Edge(Vertex V, Vertex W, int weight) {
        this.V = V;
        this.W = W;
        this.weight = weight;
    }

    public Vertex getV() {
        return V;
    }

    public Vertex getW() {
        return W;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex otherV(Vertex me) {
        return me.equals(V) ? W : V;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (V.equals(edge.V) && W.equals(edge.W))
                || (V.equals(edge.W) && W.equals(edge.V));
    }

    @Override
    public int hashCode() {
        return Objects.hash(V, W);
    }

    @Override
    public String toString() {
        return String.format("Edge(%d, %d, %d)", V.getId(), W.getId(), weight);
    }

    @Override
    public int compareTo(Edge o) {
        return Comparator.comparingInt(Edge::getWeight).compare(this, o);
    }
}
