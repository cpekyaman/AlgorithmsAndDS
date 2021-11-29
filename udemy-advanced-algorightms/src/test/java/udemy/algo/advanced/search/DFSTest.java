package udemy.algo.advanced.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DFSTest extends GraphSearchTestBase {
    private DFS<Integer> dfs;

    @BeforeEach
    public void setup() {
        dfs = new DFS<>();
    }

    @Test
    public void testVisit() {
        // when / then
        dfs.visit(root);
    }
}
