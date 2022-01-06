package algo.ch13;

import java.util.List;

public final class TopologicalSort {
    private final Digraph graph;
    private final GraphSortOrder sortOrder;

    public TopologicalSort(Digraph graph) {
        this.graph = graph;
        this.sortOrder = new DepthFirstSortOrder(graph);
    }

    public List<Integer> order() {
        return this.sortOrder.reversePost();
    }
}
