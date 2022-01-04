package algo.ch12;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.Vertex;

public final class Digraph extends BaseGraph {
    @Override
    public Digraph addEdge(Integer v, Integer w, int weight) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);

        // only adding the edge to one direction,
        // so that only one side has adjacent lists with this edge.
        vv.addEdge(new Edge(vv, wv, weight));

        return this;
    }
}
