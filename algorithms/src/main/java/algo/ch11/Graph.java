package algo.ch11;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.*;

public final class Graph extends BaseGraph {

    public Graph(int vCap) {
        super(vCap);
    }

    @Override
    public Graph addEdge(Integer v, Integer w) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);

        // making the graph undirected with these
        vv.addEdge(wv);
        wv.addEdge(vv);

        return this;
    }
}
