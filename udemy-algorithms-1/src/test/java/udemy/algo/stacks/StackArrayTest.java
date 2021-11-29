package udemy.algo.stacks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class StackArrayTest extends Assertions {
    @Test
    public void testStack() {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(5);
        stack.push(12);
        stack.push(22);

        assertThat(stack.size()).isEqualTo(3);

        assertThat(stack.peek()).isEqualTo(22);

        assertThat(stack.pop()).isEqualTo(22);
        assertThat(stack.size()).isEqualTo(2);
    }
}
