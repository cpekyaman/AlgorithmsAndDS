package algo.ch13;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.*;

public final class DigraphCycleFinder {
    private final Digraph graph;

    private final Set<Integer> visited;
    private final Set<Integer> onStack;

    private boolean hasCycle;

    public DigraphCycleFinder(Digraph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.onStack = new HashSet<>();
        processGraph();
    }

    private void processGraph() {
        for(Vertex v : graph.vertices()) {
            if(! visited.contains(v.getId()) && ! hasCycle) {
                dfs(v.getId());
            }
        }
    }

    private void dfs(Integer v) {
        onStack.add(v);
        visited.add(v);
        for(Edge e : graph.adjacents(v)) {
            if(hasCycle) {
                break;
            }

            Integer w = e.getW().getId();
            if(! visited.contains(w)) {
                dfs(w);
            } else if(onStack.contains(w)) {
                //TODO: book also tracks the edges on cycle and verifies
                hasCycle = true;
                break;
            }
        }
        onStack.remove(v);
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }
}
