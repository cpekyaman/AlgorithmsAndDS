package algo.graph.search;

import algo.graph.BaseGraph;
import algo.graph.Edge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GraphSearchManager {
    private final BaseGraph graph;
    private final Map<Integer, GraphSearch> searches;
    private final SearchCreator sc;

    public GraphSearchManager(BaseGraph graph, SearchCreator sc) {
        this.graph = graph;
        this.searches = new HashMap<>();
        this.sc = sc;
    }

    public boolean isConnected(Integer from, Integer to) {
        GraphSearch dfs = this.searches.computeIfAbsent(from, v -> sc.create(graph, v));
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
