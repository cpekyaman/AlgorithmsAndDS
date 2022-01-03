package algo.graph;

import java.util.Objects;

// sort of a directed edge as edge(a,b) is not equal to edge(b,a)
public final class Edge {
    private final Vertex from;
    private final Vertex to;
    private final int weight;

    public Edge(Vertex from, Vertex to) {
        this(from, to, 1);
    }

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return from.equals(edge.from) && to.equals(edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return String.format("Edge(%d, %d, %d)", from.getId(), to.getId(), weight);
    }
}
