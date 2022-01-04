package algo.ch13;

import algo.ch11.Graph;
import algo.graph.GraphUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

class MSTTest extends Assertions {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = GraphUtil.weightedTestGraph(new Graph());
    }

    @ParameterizedTest
    @MethodSource("mstAlgorithms")
    void shouldBeAbleToFindMST(Function<Graph, MST> mstCtor) {
        // given
        MST mst = mstCtor.apply(graph);

        // when / then
        assertThat(mst.edges()).contains(graph.edgeOf(6, 2), graph.edgeOf(2, 3),
                                         graph.edgeOf(0, 2), graph.edgeOf(0, 7),
                                         graph.edgeOf(1, 7), graph.edgeOf(5, 7),
                                         graph.edgeOf(4, 5));
    }

    static Stream<Function<Graph, MST>> mstAlgorithms() {
        return Stream.of(KruskalMST::new, LazyPrimMST::new);
    }
}