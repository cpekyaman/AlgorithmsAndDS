package algo.ch07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryHeapTest extends Assertions {

    @Test
    void shouldBeAbleToHandleInserts() {
        // given
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer.class, 10);

        // when
        heap.insert(6);

        heap.insert(7);
        heap.insert(3);

        heap.insert(2);
        heap.insert(5);

        heap.insert(1);
        heap.insert(4);

        heap.insert(8);

        // then
        assertThat(heap.peekMax()).isEqualTo(8);
        assertThat(heap.popMax()).isEqualTo(8);
        assertThat(heap.peekMax()).isEqualTo(7);

        // and
        heap.insert(9);
        // then
        assertThat(heap.peekMax()).isEqualTo(9);
    }

    @Test
    void shouldBeAbleToSortAnArray() {
        // given
        Character[] chars = new Character[]{ 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        // when
        Character[] sorted = new BinaryHeap<>(chars).sort();

        // then
        assertThat(sorted).containsExactly('A', 'E', 'E','L', 'M', 'O', 'P', 'R', 'S', 'T', 'X');

    }
}