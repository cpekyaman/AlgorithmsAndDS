package algo.ch13;

import algo.graph.GraphUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopologicalSortTest extends Assertions {

    private Digraph graph;

    @BeforeEach
    void setUp() {
        graph = GraphUtil.directedTestGraph();
    }

    @Test
    void shouldFindTheOrderIfAcyclicGraph() {
        // given
        TopologicalSort sort = new TopologicalSort(graph);

        // when / then
        System.out.println(sort.order());
        assertThat(sort.order()).containsExactly(3, 6, 0, 5, 2, 1, 4);
    }
}