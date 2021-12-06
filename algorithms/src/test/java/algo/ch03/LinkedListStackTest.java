package algo.ch03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListStackTest extends Assertions {

    @Test
    void shouldBeEmptyInitially() {
        // given
        Stack<String> stack = new LinkedListStack<>();

        // then
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.peek()).isNull();
        assertThat(stack.pop()).isNull();
    }

    @Test
    void shouldBeAbleToPushAndPop() {
        // given
        Stack<String> stack = new LinkedListStack<>();

        // when
        stack.push("first");

        // then
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.pop()).isEqualTo("first");
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void peekShouldNotRemoveHead() {
        // given
        Stack<String> stack = new LinkedListStack<>();
        stack.push("first");

        // when
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.peek()).isEqualTo("first");
        assertThat(stack.isEmpty()).isFalse();
    }
}