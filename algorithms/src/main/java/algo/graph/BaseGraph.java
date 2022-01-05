package algo.graph;

import java.util.*;

public abstract class BaseGraph {
    private final Map<Integer, Vertex> vertices;
    private final List<Edge> edges;

    protected BaseGraph() {
        this.vertices = new HashMap<>();
        this.edges = new LinkedList<>();
    }

    public int size() {
        return vertices.size();
    }

    public Collection<Vertex> vertices() {
        return Collections.unmodifiableCollection(this.vertices.values());
    }

    public List<Edge> edges() {
        return Collections.unmodifiableList(this.edges);
    }

    public Vertex vertexOf(Integer id) {
        return vertices.get(id);
    }

    public Edge edgeOf(Integer v, Integer w) {
        return newEdge(getOrCreate(v), getOrCreate(w), 1);
    }

    public BaseGraph addEdge(Integer v, Integer w) {
        return addEdge(v, w, 1);
    }

    public BaseGraph addEdge(Integer v, Integer w, int weight) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);

        Edge edge = newEdge(vv, wv, weight);
        edges.add(edge);
        return addEdge(edge);
    }

    protected abstract Edge newEdge(Vertex vv, Vertex wv, int weight);

    protected abstract BaseGraph addEdge(Edge edge);

    private Vertex getOrCreate(Integer v) {
        return vertices.computeIfAbsent(v, Vertex::new);
    }

    public List<Edge> adjacents(Integer v) {
        if(vertices.containsKey(v)) {
            return Collections.unmodifiableList(vertices.get(v).getEdges());
        }
        return Collections.emptyList();
    }
}
