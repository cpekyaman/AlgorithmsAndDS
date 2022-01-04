package algo.ch11;

import algo.graph.BaseGraph;
import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.*;

public final class Graph extends BaseGraph {
    @Override
    public Graph addEdge(Integer v, Integer w, int weight) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);

        // adding same edge on both sides to have undirected semantics
        Edge edge = new Edge(vv, wv, weight);
        vv.addEdge(edge);
        wv.addEdge(edge);

        return this;
    }
}
