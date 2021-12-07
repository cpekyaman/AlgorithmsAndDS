package algo.ch04;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShellSortTest extends Assertions {

    @Test
    void shouldBeAbleToSortChars() {
        // given
        Character[] chars = new Character[]{ 'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        // when
        Character[] sorted = new ShellSort<>(chars).sort();

        // then
        assertThat(sorted).containsExactly('A', 'E', 'E', 'E', 'H', 'L', 'L', 'L', 'M', 'O', 'P', 'R', 'S', 'S', 'T', 'X');
    }
}