package algo.ch16;

import algo.graph.Vertex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowEdgeTest extends Assertions {

    private FlowEdge edge;

    @BeforeEach
    void setUp() {
        edge = new FlowEdge(new Vertex(1), new Vertex(2), 10);
    }

    @Test
    void shouldNotAcceptNegativeWeightAsCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new FlowEdge(new Vertex(1), new Vertex(2), -5));
    }

    @Test
    void shouldNotAcceptUnknownVertexForResidualCapacity() {
        assertThrows(IllegalArgumentException.class, () -> edge.residualCapacity(4));
    }

    @Test
    void shouldNotAcceptUnknownVertexForAddFlow() {
        assertThrows(IllegalArgumentException.class, () -> edge.addFlow(4, 3));
    }

    @Test
    void shouldHaveForwardResidualCapacityEqualToCapacityInitially() {
        assertThat(edge.residualCapacity(2)).isEqualTo(10);
    }

    @Test
    void shouldHaveBackwardResidualCapacityEqualToZeroInitially() {
        assertThat(edge.residualCapacity(1)).isEqualTo(0);
    }
}