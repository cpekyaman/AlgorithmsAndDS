package udemy.algo.advanced.spanningtree.prim;

import udemy.algo.advanced.spanningtree.common.STVertex;
import udemy.algo.advanced.spanningtree.common.STEdge;

public interface NonDirectedGraphVertex<V extends NonDirectedGraphVertex> extends STVertex {
    void addAdjacent(STEdge<V> edge);
}
