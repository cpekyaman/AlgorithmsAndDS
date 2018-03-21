package udemy.algo.advanced.stronglyconnected.kosoraju;

import udemy.algo.advanced.stronglyconnected.common.DirectedGraph;

import java.util.Stack;

class DepthFirstOrder {
    private final Stack<KosarajuVertex> stack;

    DepthFirstOrder(DirectedGraph<KosarajuVertex> graph) {
        this.stack = new Stack<>();
        graph.getVertices().stream().filter(v -> ! v.isVisited()).forEach(this::dfs);
    }

    private void dfs(KosarajuVertex vertex) {
        vertex.setVisited(true);
        vertex.getNeighbours().stream().filter(v -> ! v.isVisited()).forEach(this::dfs);
        this.stack.push(vertex);
    }

    Stack<KosarajuVertex> getDFSStack() {
        return this.stack;
    }
}
