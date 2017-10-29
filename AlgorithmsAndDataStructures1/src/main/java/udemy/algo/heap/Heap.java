package udemy.algo.heap;

import java.util.Arrays;

public class Heap {
    private Integer[] heap;
    private int currentPos = -1;

    public Heap(int size) {
        this.heap = new Integer[size];
    }

    public void insert(Integer item) {
        if(isFull()) {
            throw new IllegalStateException("Heap is full");
        }
        this.heap[++currentPos] = item;
        fixUp(currentPos);
    }

    public void heapsort() {
        for(int i = 0; i <= currentPos; ++i) {
            swap(0, currentPos - i);
            fixDown(0, currentPos - i - 1);
        }
    }

    public void print() {
        Arrays.stream(this.heap).forEach(i -> System.out.printf("%d ", i));
        System.out.println();
    }

    public Integer removeMax() {
        Integer result = this.heap[0];

        this.heap[0] = this.heap[currentPos--];
        this.heap[currentPos + 1] = null;
        fixDown(0, currentPos);
        return result;
    }

    private void fixDown(int index, int upTo) {
        while(index < upTo) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if(left <= upTo) {
                int childToSwap;
                if(right > upTo) {
                    childToSwap = left;
                } else {
                    childToSwap = (heap[left] > heap[right]) ? left : right;
                }

                if(heap[index] < heap[childToSwap]) {
                    swap(index, childToSwap);
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }

    private void fixUp(int index) {
        int parentIndex = parentIndex(index);
        while(parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int source, int target) {
        int temp = this.heap[source];
        this.heap[source] = this.heap[target];
        this.heap[target] = temp;
    }

    private boolean isFull() {
        return currentPos == this.heap.length;
    }
}
