package algo.ch13;

import java.util.List;

public final class TopologicalSort {
    private final GraphSortOrder sortOrder;

    public TopologicalSort(Digraph graph) {
        if(new DigraphCycleFinder(graph).hasCycle()) {
            this.sortOrder = new NilSortOrder();
        } else {
            this.sortOrder = new DepthFirstSortOrder(graph);
        }
    }

    public List<Integer> order() {
        return this.sortOrder.reversePost();
    }

    public boolean hasOrder() {
        return ! this.sortOrder.reversePost().isEmpty();
    }
}
