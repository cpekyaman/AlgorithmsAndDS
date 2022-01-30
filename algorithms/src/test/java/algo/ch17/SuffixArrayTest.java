package algo.ch17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SuffixArrayTest extends Assertions {

    @Test
    void shouldFindLongestRepeatedSubstring() {
        // given
        String data = "ABRACADABRA!";

        // when
        String lrs = new SuffixArray(data).lrs();

        // then
        assertThat(lrs).isEqualTo("ABRA");
    }

}