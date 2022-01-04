package algo.graph.search;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.ch11.Graph;
import algo.graph.Vertex;

import java.util.*;

abstract class GraphSearchImpl implements GraphSearch {
    protected final BaseGraph graph;
    protected final Vertex from;

    protected final Set<Integer> visited;
    protected final Map<Integer, Edge> connections;

    protected GraphSearchImpl(BaseGraph graph, Integer from) {
        this.graph = graph;
        this.from = graph.vertexOf(from);
        this.visited = new HashSet<>();
        this.connections = new HashMap<>();
    }

    @Override
    public List<Edge> findPath(Integer to) {
        List<Edge> path = new LinkedList<>();
        fillPath(path, graph.vertexOf(to));
        return path;
    }

    private void fillPath(List<Edge> path, Vertex currentV) {
        if(currentV.equals(from)) {
            return;
        }
        Edge edge = connections.get(currentV.getId());
        path.add(edge);
        fillPath(path, edge.otherV(currentV));
    }

    @Override
    public boolean hasConnection(Integer to) {
        return connections.containsKey(to);
    }
}
