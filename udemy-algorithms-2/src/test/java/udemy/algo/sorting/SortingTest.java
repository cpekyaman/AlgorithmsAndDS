package udemy.algo.sorting;

import org.junit.Test;

import static udemy.algo.sorting.SortTestUtils.randomArray10;
import static udemy.algo.sorting.SortTestUtils.randomArray20;
import static udemy.algo.sorting.SortTestUtils.randomPositiveArray10;

public class SortingTest {
    @Test
    public void testBogoSort() {
        // given
        BogoSort bogo = new BogoSort(randomArray10());

        // when
        System.out.println("BogoSort");
        bogo.sort();
    }

    @Test
    public void testBubbleSort() {
        // given
        BubbleSort bubble = new BubbleSort(randomArray10());

        // when
        System.out.println("BubbleSort");
        bubble.sort();
    }

    @Test
    public void testSleepSort() {
        // given
        SleepSort sleep = new SleepSort(randomPositiveArray10());

        // when
        System.out.println("SleepSort");
        sleep.sort();
    }

    @Test
    public void testSelectionSort() {
        // given
        SelectionSort selection = new SelectionSort(randomArray10());

        // when
        System.out.println("SelectionSort");
        selection.sort();
    }

    @Test
    public void testInsertionSort() {
        // given
        InsertionSort insertion = new InsertionSort(randomArray10());

        // when
        System.out.println("InsertionSort");
        insertion.sort();
    }

    @Test
    public void testShellSort() {
        ShellSort shell = new ShellSort(randomArray10());

        // when
        System.out.println("ShellSort");
        shell.sort();
    }

    @Test
    public void testQuickSort() {
        // given
        QuickSort quick = new QuickSort(randomArray20());

        // when
        quick.sort();
    }

    @Test
    public void testMergeSort() {
        // given
        MergeSort merge = new MergeSort(randomArray20());

        // when
        merge.sort();
    }
}
