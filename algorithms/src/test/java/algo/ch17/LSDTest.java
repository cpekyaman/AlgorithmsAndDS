package algo.ch17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LSDTest extends Assertions {

    @Test
    void shouldSortFixedLengthStringArray() {
        // given
        String[] array = new String[] {
                "dab", "cab", "fad", "bad", "dad", "ebb",
                "ace", "add", "fed", "bed", "fee", "bee"
        };

        // when
        String[] sorted = new LSD(array).sort();

        // then
        assertThat(sorted).containsExactly("ace", "add", "bad", "bed", "bee", "cab",
                                           "dab", "dad", "ebb", "fad", "fed", "fee");
    }

}