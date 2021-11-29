package grokalg.ch02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SelectionSortTest extends Assertions {

    @Test
    void testSort() {
        // given
        Integer[] numbers = new Integer[]{5, 20, 12, 7, 2, 8, 3, 19, 6};
        SelectionSort<Integer> sorter = new SelectionSort<>(numbers);

        // when
        List<Integer> sortedList = sorter.sorted();

        // then
        System.out.println(sortedList);
        assertThat(sortedList.get(0)).isEqualTo(2);
        assertThat(sortedList.get(sortedList.size() - 1)).isEqualTo(20);
    }
}