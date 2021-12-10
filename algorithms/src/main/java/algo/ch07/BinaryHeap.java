package algo.ch07;

import algo.util.SortUtils;

import java.lang.reflect.Array;

public final class BinaryHeap<T extends Comparable<T>> {
    private final T[] heap;
    private int current = -1;

    public BinaryHeap(Class<T> clazz, int capacity) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, capacity);
        this.heap = array;
    }

    public BinaryHeap(T[] array) {
        this.heap = array;
        this.current = array.length - 1;
    }

    public T peekMax() {
        return heap[0];
    }

    // get the current top
    // replace top with lowest
    // sink the top
    public T popMax() {
        T max = heap[0];
        heap[0] = heap[current--];
        heap[current + 1] = null;
        sink(0, current);
        return max;
    }

    public boolean insert(T item) {
        if(current == heap.length - 1) {
            return false;
        }

        heap[++current] = item;
        swim(current);
        return true;
    }

    public T[] sort() {
        buildHeap();
        sortHeap();
        return heap;
    }

    private void buildHeap() {
        for (int i = current / 2; i >= 0 ; i--) {
            sink(i, current);
        }
    }

    private void sortHeap() {
        while(current > 0) {
            SortUtils.swap(heap, 0, current);
            sink(0, --current);
        }
    }

    private void swim(int index) {
        int itemPos = index;
        int parentPos = parentPos(itemPos);
        while(parentPos >= 0 && heap[parentPos].compareTo(heap[itemPos]) < 0) {
            SortUtils.swap(heap, itemPos, parentPos);
            itemPos = parentPos;
            parentPos = parentPos(itemPos);
        }
    }

    private void sink(int index, int sinkUntil) {
        int itemPos = index;
        int childPos = leftChildPos(itemPos);
        while(childPos <= sinkUntil) {
            if(childPos < sinkUntil && heap[childPos].compareTo(heap[childPos + 1]) < 0) {
                childPos++;
            }
            if(heap[itemPos].compareTo(heap[childPos]) > 0) {
                break;
            }
            SortUtils.swap(heap, itemPos, childPos);
            itemPos = childPos;
            childPos = leftChildPos(itemPos);
        }
    }

    private int parentPos(int index) {
        return (index - 1) / 2;
    }

    private int leftChildPos(int index) {
        return 2 * index + 1;
    }
}
