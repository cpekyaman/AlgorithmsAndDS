package algo.graph;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectedEdgeTest extends Assertions {

    @Test
    void edgesWithSameVerticesShouldBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new DirectedEdge(one, two);
        Edge second = new DirectedEdge(one, two);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    void edgesWithReversedVerticesShouldNotBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new DirectedEdge(one, two);
        Edge second = new DirectedEdge(two, one);

        // then
        assertThat(first).isNotEqualTo(second);
    }

    @Test
    void edgesWithSameVerticesAndDifferentWeightsShouldStillBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new DirectedEdge(one, two, 1);
        Edge second = new DirectedEdge(one, two, 2);

        // then
        assertThat(first).isEqualTo(second);
    }
}