package algo.ch11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectedComponentsTest extends Assertions {
    private Graph graph;

    @BeforeEach
    void setUp() {
        this.graph = GraphUtil.testGraph(new Graph());
    }

    @Test
    void verticesThatAreConnectedShouldHaveTheSameComponentId() {
        // given
        ConnectedComponents cc = new ConnectedComponents(graph);

        // when / then
        assertThat(cc.componentId(4)).isEqualTo(cc.componentId(6));
    }

    @Test
    void verticesThatAreNotConnectedShouldHaveTheDifferentComponentId() {
        // given
        ConnectedComponents cc = new ConnectedComponents(graph);

        // when / then
        assertThat(cc.componentId(5)).isNotEqualTo(cc.componentId(9));
    }
}