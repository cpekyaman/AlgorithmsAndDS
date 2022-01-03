package algo.ch11;

import java.util.Objects;

// sort of a directed edge as edge(a,b) is not equal to edge(b,a)
public final class Edge {
    private final Vertex source;
    private final Vertex target;
    private final int weight;

    public Edge(Vertex source, Vertex target) {
        this(source, target, 1);
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source.equals(edge.source) && target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }

    @Override
    public String toString() {
        return String.format("Edge(%d, %d, %d)", source.getId(), target.getId(), weight);
    }
}
