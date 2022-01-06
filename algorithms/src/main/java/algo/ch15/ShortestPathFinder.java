package algo.ch15;

import algo.ch13.Digraph;
import algo.graph.Edge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ShortestPathFinder {
    private final Digraph graph;
    private final ShortestPathSearchCreator sc;
    private final Map<Integer, ShortestPathSearch> searches;

    public ShortestPathFinder(Digraph graph, ShortestPathSearchCreator sc) {
        this.graph = graph;
        this.sc = sc;
        this.searches = new HashMap<>();
    }

    public boolean hasPath(Integer from, Integer to) {
        ShortestPathSearch sps = this.searches.computeIfAbsent(from, v -> sc.create(graph, v));
        return sps.hasPathTo(to);
    };

    public List<Edge> path(Integer from, Integer to) {
        if(! hasPath(from, to)) {
            return Collections.emptyList();
        }

        ShortestPathSearch sps = this.searches.get(from);
        return sps.pathTo(to);
    }
}
