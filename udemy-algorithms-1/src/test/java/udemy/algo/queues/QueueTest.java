package udemy.algo.queues;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class QueueTest extends Assertions {
    @Test
    public void testQueue() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertThat(queue.size()).isEqualTo(3);

        assertThat(queue.dequeue()).isEqualTo(10);
        assertThat(queue.size()).isEqualTo(2);

        assertThat(queue.peek()).isEqualTo(20);
        assertThat(queue.size()).isEqualTo(2);
    }
}
