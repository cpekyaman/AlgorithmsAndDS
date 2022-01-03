package algo.ch11;

import algo.graph.Edge;
import algo.graph.Vertex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EdgeTest extends Assertions {

    @Test
    void edgesWithSameVerticesShouldBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new Edge(one, two);
        Edge second = new Edge(one, two);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    void edgesWithReversedVerticesShouldNotBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new Edge(one, two);
        Edge second = new Edge(two, one);

        // then
        assertThat(first).isNotEqualTo(second);
    }
}