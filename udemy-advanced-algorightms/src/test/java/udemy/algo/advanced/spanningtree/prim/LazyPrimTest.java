package udemy.algo.advanced.spanningtree.prim;

import org.junit.Before;
import org.junit.Test;
import udemy.algo.advanced.spanningtree.common.STEdge;

import java.util.HashSet;
import java.util.Set;

public class LazyPrimTest {
    private LazyPrim prim;
    private Set<LazyPrimVertex> vertices;
    private LazyPrimVertex startVertex;

    @Before
    public void setup() {
        vertices = new HashSet<>();

        LazyPrimVertex vxA = new LazyPrimVertex("A");
        LazyPrimVertex vxB = new LazyPrimVertex("B");
        LazyPrimVertex vxC = new LazyPrimVertex("C");

        vertices.add(vxA);
        vertices.add(vxB);
        vertices.add(vxC);

        vxA.addAdjacent(new STEdge<>(vxA, vxB, 1.0));
        vxA.addAdjacent(new STEdge<>(vxA, vxC, 1.0));

        vxB.addAdjacent(new STEdge<>(vxB, vxC, 5.0));
        vxB.addAdjacent(new STEdge<>(vxB, vxA, 1.0));

        vxC.addAdjacent(new STEdge<>(vxC, vxA, 1.0));
        vxC.addAdjacent(new STEdge<>(vxC, vxB, 5.0));

        startVertex = vxC;
        prim = new LazyPrim(vertices);
    }

    @Test
    public void testPrim() {
        prim.mst(startVertex);
        prim.show();
    }
}
