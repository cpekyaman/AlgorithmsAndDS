package algo.graph.search;

import algo.graph.BaseGraph;
import algo.graph.Edge;

import java.util.LinkedList;
import java.util.Queue;

public final class BFS extends GraphSearchImpl {
    public BFS(BaseGraph graph, Integer from) {
        super(graph, from);
        this.findConnected();
    }

    private void findConnected() {
        Queue<Integer> bfsQueue = new LinkedList<>();

        bfsQueue.offer(from.getId());
        visited.add(from.getId());

        while(! bfsQueue.isEmpty()) {
            Integer vertex = bfsQueue.remove();

            for(Edge adj : graph.adjacents(vertex)) {
                Integer target = adj.getW().getId();
                if(! visited.contains(target)) {
                    bfsQueue.offer(target);
                    visited.add(target);
                    connections.put(target, adj);
                }
            }
        }
    }
}
