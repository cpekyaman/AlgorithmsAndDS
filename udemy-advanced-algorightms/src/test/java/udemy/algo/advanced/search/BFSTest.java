package udemy.algo.advanced.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BFSTest extends GraphSearchTestBase {
    private BFS<Integer> bfs;

    @BeforeEach
    public void setup() {
        bfs = new BFS<>();
    }

    @Test
    public void testVisit() {
        // when / then
        bfs.visit(root);
    }
}
