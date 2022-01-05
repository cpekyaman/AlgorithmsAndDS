package algo.ch12;

import algo.graph.*;

public final class Digraph extends BaseGraph {
    @Override
    protected Digraph addEdge(Edge edge) {
        if(! (edge instanceof DirectedEdge)) {
            throw new IllegalArgumentException("unsupported edge type");
        }

        // only adding the edge to one direction, so that only one side has adjacent lists with this edge.
        ((DirectedEdge)edge).from().addEdge(edge);

        return this;
    }

    @Override
    protected Edge newEdge(Vertex vv, Vertex wv, int weight) {
        return new DirectedEdge(vv, wv, weight);
    }
}
