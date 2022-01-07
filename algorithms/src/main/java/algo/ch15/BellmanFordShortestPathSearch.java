package algo.ch15;

import algo.ch13.Digraph;
import algo.graph.Edge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class BellmanFordShortestPathSearch extends ShortestPathSearchImpl {
    private final Queue<Integer> relaxQueue;
    private final Set<Integer> queued;

    public BellmanFordShortestPathSearch(Digraph graph, Integer from) {
        super(graph, from);
        this.queued = new HashSet<>();
        this.relaxQueue = new LinkedList<>();
        processGraph();
    }

    private void processGraph() {
        distances.put(from, 0);

        relaxQueue.offer(from);
        queued.add(from);
        while(! relaxQueue.isEmpty() && ! negativeCycleFound()) {
            Integer v = relaxQueue.remove();
            queued.remove(v);
            graph.adjacents(v).forEach(this::relax);
        }
    }

    @Override
    protected void relaxEdgeUpdate(Edge edge, int newDistance) {
        Integer w = edge.getW().getId();
        if(! queued.contains(w)) {
            relaxQueue.offer(w);
            queued.add(w);
        }
    }

    // TODO: implement this
    private boolean negativeCycleFound() {
        return false;
    }
}
