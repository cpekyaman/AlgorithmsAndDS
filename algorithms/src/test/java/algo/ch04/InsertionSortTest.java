package algo.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest extends Assertions {

    @Test
    void shouldBeAbleToSortString() {
        // given
        String[] strings = new String[] { "database", "cabbage", "zero", "apple", "banana", "yardstick" };

        // when
        String[] sortedArray = new InsertionSort<>(strings).sort();

        // then
        assertThat(sortedArray).containsExactly("apple", "banana", "cabbage", "database", "yardstick", "zero");
    }
}