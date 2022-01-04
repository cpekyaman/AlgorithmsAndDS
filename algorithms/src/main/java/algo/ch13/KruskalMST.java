package algo.ch13;

import algo.ch01.WeightedQuickUnion;
import algo.ch11.Graph;
import algo.graph.Edge;

import java.util.*;

public final class KruskalMST implements MST {

    private final Graph graph;
    private final List<Edge> mst;

    public KruskalMST(Graph graph) {
        this.graph = graph;
        this.mst = new LinkedList<>();
        buildMST();
    }

    private void buildMST() {
        List<Edge> edges = new ArrayList<>(graph.edges());
        edges.sort(Comparator.naturalOrder());

        WeightedQuickUnion qu = new WeightedQuickUnion(graph.size());
        for (int i = 0; i < edges.size() && mst.size() < graph.size() - 1; i++) {
            Edge smallestEdge = edges.get(i);
            if(! qu.isConnected(smallestEdge.getV().getId(), smallestEdge.getW().getId())) {
                qu.union(smallestEdge.getV().getId(), smallestEdge.getW().getId());
                mst.add(smallestEdge);
            }
        }
    }

    @Override
    public List<Edge> edges() {
        return mst;
    }
}
