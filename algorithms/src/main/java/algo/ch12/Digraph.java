package algo.ch12;

import algo.graph.BaseGraph;
import algo.graph.Edge;

public final class Digraph extends BaseGraph {
    @Override
    public Digraph addEdge(Edge edge) {
        // only adding the edge to one direction,
        // so that only one side has adjacent lists with this edge.
        edge.getV().addEdge(edge);

        return this;
    }
}
