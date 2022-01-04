package algo.graph;

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
    void edgesWithReversedVerticesShouldAlsoBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new Edge(one, two);
        Edge second = new Edge(two, one);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    void edgesWithSameVerticesAndDifferentWeightsShouldStillBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new Edge(one, two, 1);
        Edge second = new Edge(one, two, 2);

        // then
        assertThat(first).isEqualTo(second);
    }
}