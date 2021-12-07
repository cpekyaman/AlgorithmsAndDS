package algo.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ShufflerTest extends Assertions {

    @Test
    void shouldShuffleACardDeck() {
        // given
        String[] quarterDeck = new String[] {
                "Ace", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        // when
        String[] shuffled = new Shuffler<>(quarterDeck).shuffle();

        // then
        System.out.println(Arrays.toString(shuffled));
        assertThat(shuffled).containsExactlyInAnyOrder("Ace", "Two", "Three", "Four", "Five", "Six",
                                                       "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King");
    }
}