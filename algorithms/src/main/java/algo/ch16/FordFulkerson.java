package algo.ch16;

import algo.graph.Edge;

import java.util.*;

public final class FordFulkerson {
    private final FlowGraph graph;
    private final Integer from;
    private final Integer to;

    private final Set<Integer> visited;
    private final Map<Integer, FlowEdge> edges;
    private int value;

    public FordFulkerson(FlowGraph graph, Integer from, Integer to) {
        this.graph = graph;
        this.from = from;
        this.to = to;
        this.edges = new HashMap<>();
        this.visited = new HashSet<>();
        processGraph();
    }

    public int getValue() {
        return value;
    }

    private void processGraph() {
        while(hasAugmentingPath()) {
            int bottleneck = Integer.MAX_VALUE;
            for(Integer v = to; !v.equals(from); v = edges.get(v).other(v).getId()) {
                bottleneck = Integer.min(bottleneck, edges.get(v).residualCapacity(v));
            }

            for(Integer v = to; !v.equals(from); v = edges.get(v).other(v).getId()) {
                edges.get(v).addFlow(v, bottleneck);
            }
            value += bottleneck;
        }
    }

    private boolean hasAugmentingPath() {
        edges.clear();
        visited.clear();

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(from);
        visited.add(from);

        // try to find a path between (s,t) that contains non-full forward and non-empty backward edges.
        while(! bfsQueue.isEmpty()) {
            Integer v = bfsQueue.remove();
            for(Edge e : graph.adjacents(v)) {
                Integer w = e.other(v).getId();
                if(! visited.contains(w) && ((FlowEdge) e).residualCapacity(w) > 0) {
                    edges.put(w, (FlowEdge)e);
                    visited.add(w);
                    bfsQueue.offer(w);
                }
            }
        }

        // we should have reached t if we were successful
        return visited.contains(to);
    }
}
