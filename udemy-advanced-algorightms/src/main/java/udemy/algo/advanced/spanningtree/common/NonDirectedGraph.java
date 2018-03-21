package udemy.algo.advanced.spanningtree.common;

import udemy.algo.advanced.spanningtree.prim.NonDirectedGraphVertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDirectedGraph<T extends NonDirectedGraphVertex<T>> {
    private Set<T> vertices;
    private List<STEdge<T>> edges;

    public NonDirectedGraph() {
        vertices = new HashSet<>();
        edges = new ArrayList<>();
    }

    public void addVertex(T vertex) {
        this.vertices.add(vertex);
    }

    public void addEdge(STEdge<T> edge) {
        //TODO: what if not found ?
        T start = findInSet(edge.getStart());
        T end = findInSet(edge.getEnd());

        start.addAdjacent(new STEdge<>(start, end, edge.getWeight()));
        end.addAdjacent(new STEdge<>(end, start, edge.getWeight()));
    }

    public Set<T> getVertices() {
        return vertices;
    }

    public void setVertices(Set<T> vertices) {
        this.vertices = vertices;
    }

    public List<STEdge<T>> getEdges() {
        return edges;
    }

    private T findInSet(T vertex) {
        return vertices.stream()
                .filter(vertex::equals)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
