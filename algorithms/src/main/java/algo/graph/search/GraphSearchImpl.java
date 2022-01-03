package algo.graph.search;

import algo.graph.Edge;
import algo.ch11.Graph;

import java.util.*;

abstract class GraphSearchImpl implements GraphSearch {
    protected final Graph graph;
    protected final Integer from;

    protected final Set<Integer> visited;
    protected final Map<Integer, Edge> connections;

    protected GraphSearchImpl(Graph graph, Integer from) {
        this.graph = graph;
        this.from = from;
        this.visited = new HashSet<>();
        this.connections = new HashMap<>();
    }

    @Override
    public List<Edge> findPath(Integer to) {
        List<Edge> path = new LinkedList<>();
        fillPath(path, to);
        return path;
    }

    private void fillPath(List<Edge> path, Integer currentV) {
        if(currentV.equals(from)) {
            return;
        }
        Edge edge = connections.get(currentV);
        path.add(edge);
        fillPath(path, edge.getFrom().getId());
    }

    @Override
    public boolean hasConnection(Integer to) {
        return connections.containsKey(to);
    }
}
