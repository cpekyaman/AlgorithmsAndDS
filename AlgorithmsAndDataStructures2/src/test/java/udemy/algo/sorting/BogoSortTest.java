package udemy.algo.sorting;

import org.junit.Before;
import org.junit.Test;

import static udemy.algo.sorting.SortTestUtils.randomArray10;

public class BogoSortTest {
    private BogoSort bogo;

    @Before
    public void setup() {

        bogo = new BogoSort(randomArray10());
    }

    @Test
    public void testSort() {
        bogo.sort();
    }
}
