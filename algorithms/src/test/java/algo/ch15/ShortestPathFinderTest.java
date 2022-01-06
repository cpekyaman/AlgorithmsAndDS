package algo.ch15;

import algo.ch13.Digraph;
import algo.graph.GraphUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortestPathFinderTest extends Assertions {

    @Test
    void shouldBeAbleToFindShortestPathInACyclicGraph() {
        // given
        Digraph graph = GraphUtil.directedWeightedTestGraph();
        ShortestPathFinder spf = new ShortestPathFinder(graph, DijkstraShortestPathSearch::new);

        // when / then
        assertThat(spf.hasPath(0, 6)).isTrue();

        assertThat(spf.path(0, 6)).contains(graph.edgeOf(0, 2),
                                            graph.edgeOf(2, 7),
                                            graph.edgeOf(7, 3),
                                            graph.edgeOf(3, 6));
    }

    @Test
    void shouldBeAbleToFindShortestPathInADAG() {
        // given
        Digraph graph = GraphUtil.weightedDAG();
        ShortestPathFinder spf = new ShortestPathFinder(graph, AcyclicShortestPathSearch::new);

        // when / then
        assertThat(spf.hasPath(0, 2)).isTrue();

        assertThat(spf.path(0, 2)).contains(graph.edgeOf(0, 4),
                                            graph.edgeOf(4, 5),
                                            graph.edgeOf(5, 2));
    }
}