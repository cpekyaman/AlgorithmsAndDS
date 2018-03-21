package udemy.algo.advanced.search;

import udemy.algo.advanced.graph.GraphSearch;
import udemy.algo.advanced.graph.GraphVertex;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> implements GraphSearch<T> {
    private final Queue<GraphVertex<T>> vertices;

    public BFS() {
        this.vertices = new LinkedList<>();
    }

    @Override
    public void visit(GraphVertex<T> root) {
        this.markVertex(root);

        while(! vertices.isEmpty()) {
            GraphVertex<T> current = vertices.poll();
            current.visit();
            current.getNeighbours().stream().filter(v -> ! v.isVisited()).forEach(this::markVertex);
        }
    }

    private void markVertex(GraphVertex<T> vertex) {
        vertex.mark();
        this.vertices.offer(vertex);
    }
}
