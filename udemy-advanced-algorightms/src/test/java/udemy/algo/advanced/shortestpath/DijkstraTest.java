package udemy.algo.advanced.shortestpath;

import org.junit.Before;
import org.junit.Test;
import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

public class DijkstraTest {
    private Dijkstra spa;

    private SPVertex source;
    private SPVertex target;

    @Before
    public void setup() {
        spa = new Dijkstra();

        source = new SPVertex("A");
        SPVertex vB = new SPVertex("B");
        target = new SPVertex("C");

        source.addNeighbour(new SPEdge(1, source, vB));
        source.addNeighbour(new SPEdge(10, source, target));
        vB.addNeighbour(new SPEdge(1, vB, target));
    }

    @Test
    public void testShortestPath() {
        // when
        spa.compute(source);

        // then
        System.out.println(spa.getShortestPathTo(target));
    }
}
