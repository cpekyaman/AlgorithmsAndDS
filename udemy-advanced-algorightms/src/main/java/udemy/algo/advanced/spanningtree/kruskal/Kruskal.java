package udemy.algo.advanced.spanningtree.kruskal;

import udemy.algo.advanced.spanningtree.common.STEdge;
import udemy.algo.advanced.spanningtree.djset.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public void mst(List<KruskalVertex> vertices, List<STEdge<KruskalVertex>> edges) {
        DisjointSet set = new DisjointSet(vertices);

        List<STEdge<KruskalVertex>> mst = new ArrayList<>();
        Collections.sort(edges);

        for (STEdge<KruskalVertex> edge : edges) {
            KruskalVertex start = edge.getStart();
            KruskalVertex end = edge.getEnd();

            if (!set.areInSameSet(start, end)) {
                mst.add(edge);
                set.union(start.getNode(), end.getNode());
            }
        }
    }
}
