package algo.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest extends Assertions {

    @Test
    void shouldBeAbleToSortIntegers() {
        // given
        Integer[] intArray = new Integer[] {6, 2, 3, 4, 7, 1, 9};

        // when
        Integer[] sortedArray = new SelectionSort<>(intArray).sort();

        // then
        assertThat(sortedArray).containsExactly(1, 2, 3, 4, 6, 7, 9);
    }
}