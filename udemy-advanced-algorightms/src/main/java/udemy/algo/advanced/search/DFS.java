package udemy.algo.advanced.search;

import udemy.algo.advanced.graph.GraphSearch;
import udemy.algo.advanced.graph.GraphVertex;

public class DFS<T> implements GraphSearch<T> {
    @Override
    public void visit(GraphVertex<T> root) {
        root.visit();
        root.getNeighbours().stream().filter(v -> ! v.isVisited()).forEach(this::visit);
    }
}
