package algo.graph;

import java.util.*;

public abstract class BaseGraph {
    private final Map<Integer, Vertex> vertices;

    protected BaseGraph(int vCap) {
        this.vertices = new HashMap<>(vCap);
    }

    public int size() {
        return vertices.size();
    }

    public Collection<Vertex> vertices() {
        return this.vertices.values();
    }

    public abstract BaseGraph addEdge(Integer v, Integer w);

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
