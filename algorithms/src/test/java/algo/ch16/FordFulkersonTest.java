package algo.ch16;

import algo.graph.GraphUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FordFulkersonTest extends Assertions {

    private FlowGraph graph;

    @BeforeEach
    void setUp() {
        graph = GraphUtil.testFlowGraph();
    }

    @Test
    void shouldBeAbleToFindMaxFlow() {
        // given
        FordFulkerson ff = new FordFulkerson(graph, 0, 7);

        // when / then
        System.out.println(ff.getValue());
        assertThat(ff.getValue()).isEqualTo(28);
    }
}