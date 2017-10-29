package udemy.algo.stacks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class StackListTest {
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(12);
        stack.push(22);
        Assert.assertSame(3, stack.size());

        Assert.assertSame(22, stack.peek());

        Assert.assertSame(22, stack.pop());
        Assert.assertSame(2, stack.size());
    }
}
