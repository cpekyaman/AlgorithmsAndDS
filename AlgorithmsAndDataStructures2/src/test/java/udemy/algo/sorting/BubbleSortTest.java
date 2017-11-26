package udemy.algo.sorting;

import org.junit.Before;
import org.junit.Test;

import static udemy.algo.sorting.SortTestUtils.randomArray10;

public class BubbleSortTest {
    private BubbleSort bubbleSort;

    @Before
    public void setup() {
        bubbleSort = new BubbleSort(randomArray10());
    }

    @Test
    public void testSort() {
        bubbleSort.sort();
    }
}
