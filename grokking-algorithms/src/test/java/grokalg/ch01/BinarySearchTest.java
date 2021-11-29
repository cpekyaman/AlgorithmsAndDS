package grokalg.ch01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class BinarySearchTest extends Assertions {
    @Test
    void testEvenLengthArray() {
        // given
        BinarySearch<Integer> intSearch = new BinarySearch<>(Stream.of(5, 6, 3, 9, 12, 20, 7, 2).sorted().toArray(Integer[]::new));

        // then
        assertThat(intSearch.find(22)).isEqualTo(-1);
        assertThat(intSearch.find(5)).isEqualTo(2);
        assertThat(intSearch.find(20)).isEqualTo(7);
    }

    @Test
    void testOddLengthArray() {
        // given
        BinarySearch<Integer> intSearch = new BinarySearch<>(Stream.of(5, 6, 3, 9, 20, 7, 2).sorted().toArray(Integer[]::new));

        // then
        assertThat(intSearch.find(22)).isEqualTo(-1);
        assertThat(intSearch.find(5)).isEqualTo(2);
        assertThat(intSearch.find(20)).isEqualTo(6);
    }

    @Test
    void testEmptyArray() {
        // given
        BinarySearch<Integer> intSearch = new BinarySearch<>(new Integer[]{});

        // then
        assertThat(intSearch.find(22)).isEqualTo(-1);
        assertThat(intSearch.find(5)).isEqualTo(-1);
        assertThat(intSearch.find(20)).isEqualTo(-1);
    }

    @Test
    void testSingleElementArray() {
        // given
        BinarySearch<Integer> intSearch = new BinarySearch<>(new Integer[]{6});

        // then
        assertThat(intSearch.find(22)).isEqualTo(-1);
        assertThat(intSearch.find(6)).isEqualTo(0);
        assertThat(intSearch.find(20)).isEqualTo(-1);
    }
}
