package udemy.algo.tst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TSTTest extends Assertions {
    private TST tst;

    @BeforeEach
    public void setup() {
        tst = new TST();
    }

    @Test
    public void testPutAndGet() {
        // given
        tst.put("apple", 1);
        tst.put("orange", 2);

        // then
        assertThat(tst.get("orange")).isEqualTo(2);
        assertThat(tst.get("banana")).isNull();
        assertThat(tst.get("orangutan")).isNull();
    }
}
