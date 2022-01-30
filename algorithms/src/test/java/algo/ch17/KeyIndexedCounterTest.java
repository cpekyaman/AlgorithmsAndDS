package algo.ch17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KeyIndexedCounterTest extends Assertions {

    @Test
    void shouldSortCharArray() {
        // given
        char[] array = new char[] {'d', 'a', 'c', 'f', 'f', 'b', 'd', 'b', 'f', 'b', 'e', 'a'};

        // when
        char[] sorted = new KeyIndexedCounter(array, 6).sort();

        // then
        assertThat(sorted).contains('a', 'a', 'b', 'b', 'b', 'c', 'd', 'd', 'e', 'f', 'f', 'f');
    }
}