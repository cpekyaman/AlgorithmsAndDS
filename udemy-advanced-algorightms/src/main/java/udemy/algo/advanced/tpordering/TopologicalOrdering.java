package udemy.algo.advanced.tpordering;

import udemy.algo.advanced.graph.GraphVertex;

import java.util.Stack;

public class TopologicalOrdering<T> {
    private final Stack<GraphVertex<T>> vertices;

    public TopologicalOrdering() {
        this.vertices = new Stack<>();
    }

    //TODO: DFS of this is different than DFS class ?
    public void order(GraphVertex<T> root) {
        root.mark();
        root.getNeighbours().stream().filter(v -> ! v.isVisited()).forEach(this::order);
        this.vertices.push(root);
    }

    public Stack<GraphVertex<T>> getVertices() {
        return vertices;
    }
}
