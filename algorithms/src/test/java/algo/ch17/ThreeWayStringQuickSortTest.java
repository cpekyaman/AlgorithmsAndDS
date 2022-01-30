package algo.ch17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ThreeWayStringQuickSortTest extends Assertions {

    @Test
    void shouldSortVariedLengthStringArray() {
        // given
        String[] array = "she sells seashells by the sea shore the shells she sells are surely seashells".split(" ");

        // when
        String[] sorted = new ThreeWayStringQuickSort(array).sort();

        // then
        assertThat(sorted).containsExactly("are", "by", "sea", "seashells", "seashells", "sells", "sells",
                                           "she", "she", "shells", "shore", "surely", "the", "the");
    }

}