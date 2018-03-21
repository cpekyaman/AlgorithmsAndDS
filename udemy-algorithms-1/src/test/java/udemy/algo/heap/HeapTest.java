package udemy.algo.heap;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {
    private Heap heap;

    @Before
    public void setup() {
        heap = new Heap(10);

        heap.insert(1);
        heap.insert(23);
        heap.insert(56);
        heap.insert(3);
        heap.insert(10);
        heap.insert(-5);
    }

    //TODO: check implementation of heapsort
    @Test
    public void testHeapSort() {
        // when
        heap.heapsort();

        // then
        heap.print();
    }
}
