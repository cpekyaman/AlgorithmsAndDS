package algo.ch11.search;

import algo.ch11.Edge;
import algo.ch11.Graph;

import java.util.LinkedList;
import java.util.Queue;

public final class BFS extends GraphSearchImpl {
    public BFS(Graph graph, Integer from) {
        super(graph, from);
        this.findConnected();
    }

    private void findConnected() {
        Queue<Integer> bfsQueue = new LinkedList<>();

        bfsQueue.offer(from);
        visited.add(from);

        while(! bfsQueue.isEmpty()) {
            Integer vertex = bfsQueue.remove();

            for(Edge adj : graph.adjacents(vertex)) {
                Integer target = adj.getTarget().getId();
                if(! visited.contains(target)) {
                    bfsQueue.offer(target);
                    visited.add(target);
                    connections.put(target, adj);
                }
            }
        }
    }
}
