package algo.graph;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UndirectedEdgeTest extends Assertions {

    @Test
    void edgesWithSameVerticesShouldBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new UndirectedEdge(one, two);
        Edge second = new UndirectedEdge(one, two);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    void edgesWithReversedVerticesShouldAlsoBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new UndirectedEdge(one, two);
        Edge second = new UndirectedEdge(two, one);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    void edgesWithSameVerticesAndDifferentWeightsShouldStillBeEqual() {
        // given
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);

        // when
        Edge first = new UndirectedEdge(one, two, 1);
        Edge second = new UndirectedEdge(one, two, 2);

        // then
        assertThat(first).isEqualTo(second);
    }
}