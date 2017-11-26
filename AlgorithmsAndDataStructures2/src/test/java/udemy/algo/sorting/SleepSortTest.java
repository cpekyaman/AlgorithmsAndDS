package udemy.algo.sorting;

import org.junit.Before;
import org.junit.Test;

import static udemy.algo.sorting.SortTestUtils.randomPositiveArray10;

public class SleepSortTest {
    private SleepSort sleep;

    @Before
    public void setup() {
        sleep = new SleepSort(randomPositiveArray10());
    }

    @Test
    public void testSort() {
        sleep.sort();
    }
}
