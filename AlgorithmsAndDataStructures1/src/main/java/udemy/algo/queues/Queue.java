package udemy.algo.queues;

import udemy.algo.lists.LinkedList;

/**
 * Created by raistlin on 9/24/2017.
 */
public class Queue<T extends Comparable<T>> {
    private final LinkedList<T> list;
    private int size = 0;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T data) {
        list.addLast(data);
        size++;
    }

    public T dequeue() {
        size--;
        return list.removeFirst();
    }

    public T peek() {
        return list.head();
    }

    public int size() {
        return size;
    }
}
