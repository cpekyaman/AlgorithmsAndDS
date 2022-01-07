package algo.ch15;

import algo.ch13.Digraph;
import algo.ch13.TopologicalSort;
import algo.graph.Edge;

public final class AcyclicShortestPathSearch extends ShortestPathSearchImpl {
    public AcyclicShortestPathSearch(Digraph graph, Integer from) {
        super(graph, from);
        processGraph();
    }

    private void processGraph() {
        distances.put(from, 0);

        TopologicalSort sort = new TopologicalSort(graph);
        if(! sort.hasOrder()) {
            throw new IllegalArgumentException("not an acyclic graph");
        }
        for(Integer v : sort.order()) {
            graph.adjacents(v).forEach(this::relax);
        }
    }

    @Override
    protected void relaxEdgeUpdate(Edge edge, int newDistance) {
        // do nothing
    }
}
