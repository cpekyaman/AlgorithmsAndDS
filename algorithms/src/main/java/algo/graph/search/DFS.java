package algo.graph.search;

import algo.graph.Edge;
import algo.ch11.Graph;

public final class DFS extends GraphSearchImpl {
    public DFS(Graph graph, Integer from) {
        super(graph, from);
        this.findConnected(from);
    }

    private void findConnected(Integer v) {
        visited.add(v);

        for(Edge adj : graph.adjacents(v)) {
            Integer vertexId = adj.getTo().getId();
            if(! visited.contains(vertexId)) {
                findConnected(vertexId);
                connections.put(vertexId, adj);
            }
        }
    }
}
