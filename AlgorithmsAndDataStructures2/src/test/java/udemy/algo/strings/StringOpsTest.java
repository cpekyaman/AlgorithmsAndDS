package udemy.algo.strings;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class StringOpsTest extends Assertions {
    private StringOps ops;

    @Before
    public void setup() {
        ops = new StringOps();
    }

    @Test
    public void testReverse() {
        assertThat(ops.reverse("cenk")).isEqualTo("knec");
    }

    @Test
    public void testSuffixes() {
        assertThat(ops.suffixes("hello")).hasSize(5).containsOnly("o", "lo", "llo", "ello", "hello");
    }
}
