package algo.ch03;

// add tail node pointer, push to tail and pop from head, and you will have queue
public final class LinkedListStack<T> implements Stack<T> {

    private Node<T> head;

    @Override
    public void push(T item) {
        this.head = new Node<>(item, head);
    }

    @Override
    public T pop() {
        if(head == null) {
            return null;
        }

        T item = head.item;
        head = head.next;
        return item;
    }

    @Override
    public T peek() {
        return head != null ? head.item : null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private static final class Node<E> {
        private final E item;
        private final Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
