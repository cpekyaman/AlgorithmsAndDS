package udemy.algo.advanced.search;

import org.junit.Before;
import org.junit.Test;

public class BFSTest extends GraphSearchTestBase {
    private BFS<Integer> bfs;

    @Before
    public void setup() {
        bfs = new BFS<>();
    }

    @Test
    public void testVisit() {
        // when / then
        bfs.visit(root);
    }
}
