package algo.ch11;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.UndirectedEdge;
import algo.graph.Vertex;

public final class Graph extends BaseGraph {
    @Override
    protected Graph addEdge(Edge edge) {
        if(! (edge instanceof UndirectedEdge)) {
            throw new IllegalArgumentException("unsupported edge type");
        }

        // adding same edge on both sides to have undirected semantics
        edge.getV().addEdge(edge);
        edge.getW().addEdge(edge);

        return this;
    }

    @Override
    protected Edge newEdge(Vertex vv, Vertex wv, int weight) {
        return new UndirectedEdge(vv, wv, weight);
    }
}
