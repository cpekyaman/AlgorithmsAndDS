package algo.ch12;

import algo.graph.BaseGraph;
import algo.graph.Vertex;

public final class Digraph extends BaseGraph {
    public Digraph(int vCap) {
        super(vCap);
    }

    @Override
    public Digraph addEdge(Integer v, Integer w) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);

        vv.addEdge(wv);

        return this;
    }
}
