package algo.ch11;

import algo.graph.BaseGraph;
import algo.graph.Edge;

public final class Graph extends BaseGraph {
    @Override
    public Graph addEdge(Edge edge) {
        // adding same edge on both sides to have undirected semantics
        edge.getV().addEdge(edge);
        edge.getW().addEdge(edge);

        return this;
    }
}
