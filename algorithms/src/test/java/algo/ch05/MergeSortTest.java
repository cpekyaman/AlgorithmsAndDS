package algo.ch05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest extends Assertions {

    @Test
    void shouldWorkWithEmptyArray() {
        assertThat(new MergeSort<>(new Integer[0]).sort()).isEmpty();
    }

    @Test
    void shouldSortCharArray() {
        // given
        Character[] chars = new Character[]{ 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        // when
        Character[] sorted = new MergeSort<>(chars).sort();

        // then
        assertThat(sorted).containsExactly('A', 'E', 'E', 'E', 'E', 'G', 'L', 'M', 'M', 'O', 'P', 'R', 'R', 'S', 'T', 'X');
    }
}