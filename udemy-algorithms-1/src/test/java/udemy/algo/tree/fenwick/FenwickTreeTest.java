package udemy.algo.tree.fenwick;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FenwickTreeTest extends Assertions {

    private FenwickTree tree;

    @Before
    public void setup() {
        tree = new FenwickTree(new int[]{3,2,-1,6,5,4,-3,3,7,2,3});
    }

    @Test
    public void testRangeSumEightToTen() {
        assertThat(tree.rangeSum(8,10)).isEqualTo(12);
    }
}
