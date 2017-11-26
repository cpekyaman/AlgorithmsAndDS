package udemy.algo.sorting;

import java.util.concurrent.CountDownLatch;

public class SleepSort {
    private final int[] array;

    public SleepSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        final CountDownLatch latch = new CountDownLatch(array.length);
        for(Integer num : array) {
            new Thread(() -> {
              try {
                  Thread.sleep(num * 100);
                  System.out.printf("%d ", num);
                  latch.countDown();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
