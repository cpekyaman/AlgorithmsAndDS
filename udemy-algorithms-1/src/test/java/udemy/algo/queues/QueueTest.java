package udemy.algo.queues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class QueueTest {
    @Test
    public void testQueue() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Assert.assertSame(3, queue.size());

        Assert.assertSame(10, queue.dequeue());
        Assert.assertSame(2, queue.size());

        Assert.assertSame(20, queue.peek());
        Assert.assertSame(2, queue.size());
    }
}
