package grokalg.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class QuickSortTest extends Assertions {

    @Test
    void emptyArrayShouldNotFail() {
        // given
        int[] emptyArray = {};

        // when
        QuickSort.sort(emptyArray);

        // then
        assertThat(emptyArray).isEmpty();
    }

    @Test
    void singleElementArrayShouldReturnAsIs() {
        // given
        int[] array = new int[]{5};

        // when
        QuickSort.sort(array);

        // then
        assertThat(array).hasSize(1).containsExactly(5);
    }

    @ParameterizedTest
    @MethodSource("randomArrays")
    void shouldBeAbleToSortRandomArrays(int[] original, int[] sorted) {
        // when
        QuickSort.sort(original);

        // then
        assertThat(original).containsExactly(sorted);
    }

    static Stream<Arguments> randomArrays() {
        return Stream.of(
                Arguments.of(new int[]{3, 7}, new int[]{3, 7}),
                Arguments.of(new int[]{5, 2}, new int[]{2, 5}),
                Arguments.of(new int[]{3, 7, 9}, new int[]{3, 7, 9}),
                Arguments.of(new int[]{3, 7, 5}, new int[]{3, 5, 7}),
                Arguments.of(new int[]{9, 6, 2}, new int[]{2, 6, 9}),
                Arguments.of(new int[]{3, 1, 5, 4}, new int[]{1, 3, 4, 5}),
                Arguments.of(new int[]{3, 7, 8, 2, 5, 9, 4}, new int[]{2, 3, 4, 5, 7, 8, 9})
        );
    }

}