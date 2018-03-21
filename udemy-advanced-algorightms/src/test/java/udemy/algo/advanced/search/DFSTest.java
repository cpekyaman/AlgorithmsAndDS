package udemy.algo.advanced.search;

import org.junit.Before;
import org.junit.Test;

public class DFSTest extends GraphSearchTestBase {
    private DFS<Integer> dfs;

    @Before
    public void setup() {
        dfs = new DFS<>();
    }

    @Test
    public void testVisit() {
        // when / then
        dfs.visit(root);
    }
}
