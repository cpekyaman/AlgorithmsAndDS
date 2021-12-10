package algo.ch06;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest extends Assertions {

    @Test
    void shouldBeAbleToSortIntegers() {
        // given
        Integer[] numbers = new Integer[]{ 9, 12, 5, 3, 7, 11, 6, 2, 8};

        // when
        Integer[] sorted = new QuickSort<>(numbers).sort();

        // then
        assertThat(sorted).containsExactly(2, 3, 5, 6, 7, 8, 9, 11, 12);
    }
}