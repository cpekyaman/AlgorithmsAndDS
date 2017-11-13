package udemy.algo.substring;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BoyerMooreTest extends Assertions {
    private BoyerMoore bm;

    @Before
    public void setup() {
        bm = new BoyerMoore();
    }

    @Test
    public void testSearch() {
        assertThat(bm.search("this is a test", "test")).isEqualTo(10);
    }
}
