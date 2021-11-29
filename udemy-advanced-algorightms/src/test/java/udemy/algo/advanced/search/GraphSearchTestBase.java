package udemy.algo.advanced.search;

import org.junit.jupiter.api.BeforeEach;
import udemy.algo.advanced.graph.GraphVertex;

public abstract class GraphSearchTestBase {
    protected GraphVertex<Integer> root;

    @BeforeEach
    public void setupBase() {
        root = new GraphVertex<>(1);

        GraphVertex<Integer> v2 = new GraphVertex<>(2);
        GraphVertex<Integer> v3 = new GraphVertex<>(3);

        GraphVertex<Integer> v4 = new GraphVertex<>(4);
        GraphVertex<Integer> v5 = new GraphVertex<>(5);

        root.addNeighbour(v2);
        root.addNeighbour(v3);

        v2.addNeighbour(v4);
        v2.addNeighbour(v5);

        v3.addNeighbour(v5);
    }
}
