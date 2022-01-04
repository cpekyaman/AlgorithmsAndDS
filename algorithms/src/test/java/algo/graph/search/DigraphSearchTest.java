package algo.graph.search;

import algo.graph.GraphUtil;
import algo.ch12.Digraph;
import algo.graph.Edge;
import algo.graph.Vertex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DigraphSearchTest extends Assertions {
    private Digraph graph;

    @BeforeEach
    void setUp() {
        graph = GraphUtil.testGraph(new Digraph());
    }

    @Test
    void shouldReturnPathIfThereIsAConnectionBetweenVertices() {
        // given
        GraphSearchManager gs = new GraphSearchManager(graph, DFS::new);

        // when
        List<Edge> path = gs.path(0, 3);

        // then
        assertThat(path).contains(
                new Edge(new Vertex(5), new Vertex(3)),
                new Edge(new Vertex(6), new Vertex(4)));
    }

    @Test
    void shouldNotReturnPathIfThereIsNoConnectionBetweenVertices() {
        // given
        GraphSearchManager gs = new GraphSearchManager(graph, DFS::new);

        // when
        List<Edge> path = gs.path(6, 12);

        // then
        assertThat(path).isEmpty();
    }
}
