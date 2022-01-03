package algo.ch11;

import algo.ch11.search.DFS;
import algo.ch11.search.GraphSearch;

import java.util.*;

public final class GraphSearchManager {
    private final Graph graph;
    private final Map<Integer, GraphSearch> searches;

    public GraphSearchManager(Graph graph) {
        this.graph = graph;
        this.searches = new HashMap<>();
    }

    public boolean isConnected(Integer from, Integer to) {
        GraphSearch dfs = this.searches.computeIfAbsent(from, v -> new DFS(graph, from));
        return dfs.hasConnection(to);
    }

    public List<Edge> path(Integer from, Integer to) {
        if(! isConnected(from, to)) {
            return Collections.emptyList();
        }

        GraphSearch dfs = this.searches.get(from);
        return dfs.findPath(to);
    }
}
