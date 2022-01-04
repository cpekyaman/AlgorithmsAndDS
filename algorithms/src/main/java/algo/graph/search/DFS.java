package algo.graph.search;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.Vertex;

public final class DFS extends GraphSearchImpl {
    public DFS(BaseGraph graph, Integer from) {
        super(graph, from);
        this.findConnected(this.from);
    }

    private void findConnected(Vertex v) {
        visited.add(v.getId());

        for(Edge adj : graph.adjacents(v.getId())) {
            Vertex other = adj.otherV(v);
            if(! visited.contains(other.getId())) {
                findConnected(other);
                connections.put(other.getId(), adj);
            }
        }
    }
}
