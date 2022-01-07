package algo.ch16;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.Vertex;

public final class FlowGraph extends BaseGraph {
    @Override
    protected Edge newEdge(Vertex vv, Vertex wv, int weight) {
        return new FlowEdge(vv, wv, weight);
    }

    @Override
    protected BaseGraph addEdge(Edge edge) {
        if(! (edge instanceof FlowEdge)) {
            throw new IllegalArgumentException("unsupported edge type");
        }

        // adding same edge on both sides to have undirected semantics
        edge.getV().addEdge(edge);
        edge.getW().addEdge(edge);

        return this;
    }
}
