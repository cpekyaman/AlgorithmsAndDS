package udemy.algo.stacks;

import udemy.algo.lists.LinkedList;

/**
 * Created by raistlin on 9/9/2017.
 */
public class Stack<T extends Comparable<T>> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push(T data) {
        stack.addFirst(data);
    }

    public T pop() {
        return stack.removeFirst();
    }

    public T peek() {
        return stack.head();
    }

    public void print() {
        stack.print();
    }

    public int size() {
        return stack.size();
    }
}
