package algo.graph.search;

import algo.ch11.Graph;
import algo.ch11.GraphUtil;
import algo.graph.Edge;
import algo.graph.Vertex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GraphSearchTest extends Assertions {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = GraphUtil.testGraph(new Graph());
    }

    @Test
    void shouldReturnPathIfThereIsAConnectionBetweenVertices() {
        // given
        GraphSearchManager gs = new GraphSearchManager(graph, DFS::new);

        // when
        List<Edge> path = gs.path(1, 3);

        // then
        assertThat(path).contains(
                new Edge(new Vertex(5), new Vertex(3)),
                new Edge(new Vertex(6), new Vertex(4)),
                new Edge(new Vertex(0), new Vertex(1)));
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