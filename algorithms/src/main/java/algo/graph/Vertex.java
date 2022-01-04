package algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class Vertex {
    private final Integer id;
    private final List<Edge> edges;

    public Vertex(Integer id) {
        this.id = id;
        this.edges = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Vertex addEdge(Edge edge) {
        this.edges.add(edge);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id.equals(vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex(" + id + ')';
    }
}
