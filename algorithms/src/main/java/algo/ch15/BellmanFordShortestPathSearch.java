package algo.ch15;

import algo.ch13.Digraph;

public final class BellmanFordShortestPathSearch extends ShortestPathSearchImpl {
    public BellmanFordShortestPathSearch(Digraph graph, Integer from) {
        super(graph, from);
        processGraph();
    }

    private void processGraph() {
        distances.put(from, 0);

    }
}
