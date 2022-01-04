package algo.graph;

import java.util.*;

public abstract class BaseGraph {
    private final Map<Integer, Vertex> vertices;

    protected BaseGraph() {
        this.vertices = new HashMap<>();
    }

    public int size() {
        return vertices.size();
    }

    public Collection<Vertex> vertices() {
        return this.vertices.values();
    }

    public Vertex vertexOf(Integer id) {
        return vertices.get(id);
    }

    public BaseGraph addEdge(Integer v, Integer w) {
        return addEdge(v, w, 1);
    }

    public abstract BaseGraph addEdge(Integer v, Integer w, int weight);

    protected Vertex getOrCreate(Integer v) {
        return vertices.computeIfAbsent(v, Vertex::new);
    }

    public List<Edge> adjacents(Integer v) {
        if(vertices.containsKey(v)) {
            return vertices.get(v).getEdges();
        }
        return Collections.emptyList();
    }
}
