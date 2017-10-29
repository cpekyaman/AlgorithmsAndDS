package udemy.algo.lists;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by raistlin on 9/9/2017.
 */
public class LinkedList<T extends Comparable<T>> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public T head() {
        return first != null ? first.getData() : null;
    }

    public void addFirst(T data) {
        if(first == null) {
            first = last = new Node<>(null, data);
        } else {
            first = new Node<>(first, data);
        }
        size++;
    }

    public void addLast(T data) {
        if(last == null) {
            first = last = new Node<>(null, data);
        } else {
            last.setNext(new Node<>(null, data));
            last = last.getNext();
        }
        size++;
    }

    public T removeFirst() {
        if(first == null) {
            return null;
        }

        T data = first.getData();
        first = first.getNext();
        if(first == null) {
            last = null;
        }
        size--;

        return data;
    }

    public void removeLast() {
        //TODO
    }

    public int size() {
        return size;
    }

    public void remove(T data) {
        if(first == null) {
            return;
        } else if(first.getData().compareTo(data) == 0){
            first = first.getNext();
        } else {
            search(first, first.getNext(), data, (prev, curr) -> prev.setNext(curr.getNext()));
        }
    }

    public void print() {
        if(first != null) {
            traverse(first, System.out::println);
        }
        System.out.println();
    }

    private void search(Node<T> previous, Node<T> current, T data, BiConsumer<Node<T>, Node<T>> c) {
        if(current == null) {
            return;
        } else if(current.getData().compareTo(data) == 0) {
            c.accept(previous, current);
        } else {
            search(current, current.getNext(), data, c);
        }
    }

    private void traverse(Node<T> node, Consumer<T> c) {
        if(node != null) {
            c.accept(node.getData());
            traverse(node.getNext(), c);
        }
    }
}

class Node<T extends Comparable<T>> {
    private Node next;
    private final T data;

    Node(Node next, T data) {
        this.next = next;
        this.data = data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    T getData() {
        return data;
    }
}
