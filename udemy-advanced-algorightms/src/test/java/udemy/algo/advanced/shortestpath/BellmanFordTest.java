package udemy.algo.advanced.shortestpath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordTest {
    private BellmanFord spa;

    private List<SPVertex> vertices;

    @BeforeEach
    public void setup() {
        vertices = new ArrayList<>();
        vertices.add(new SPVertex("A"));
        vertices.add(new SPVertex("B"));
        vertices.add(new SPVertex("C"));

        List<SPEdge> edges = new ArrayList<>();
        edges.add(new SPEdge(1, vertices.get(0), vertices.get(1)));
        edges.add(new SPEdge(-1, vertices.get(0), vertices.get(2)));
        edges.add(new SPEdge(-11, vertices.get(2), vertices.get(0)));

        spa = new BellmanFord(vertices, edges);
    }

    @Test
    public void testShortestPath() {
        // when
        spa.compute(vertices.get(0));

        // then
        System.out.println(spa.getShortestPathTo(vertices.get(vertices.size() - 1)));
    }
}
