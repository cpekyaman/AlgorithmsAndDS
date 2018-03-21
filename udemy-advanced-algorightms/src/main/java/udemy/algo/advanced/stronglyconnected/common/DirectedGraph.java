package udemy.algo.advanced.stronglyconnected.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedGraph<T extends SCCVertex<T>> {
    private Set<T> vertices;
    private List<SCCEdge<T>> edges;

    public DirectedGraph(Set<T> vertices, List<SCCEdge<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public DirectedGraph<T> transpose() {
        Set<T> transposedVertices = new HashSet<>(this.vertices);

        //TODO: implement (reverse edges and neighbor list of vertices)
        return null;
    }

    public Set<T> getVertices() {
        return vertices;
    }

    private T findInSet(T vertex) {
        return vertices.stream()
                .filter(vertex::equals)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
