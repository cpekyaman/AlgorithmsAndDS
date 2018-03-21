package udemy.algo.stacks;

/**
 * Created by raistlin on 9/9/2017.
 */
public class StackArray<T> {
    private static final int INITIAL_SIZE = 128;

    private T[] array;
    private int numElements = 0;

    public StackArray() {
        array = (T[]) new Object[INITIAL_SIZE];
    }

    public void push(T data) {
        if(numElements == array.length) {
            resize(array.length * 2);
        }
        array[numElements++] = data;
    }

    public T pop() {
        if(numElements == 0) {
            return null;
        }
        T item = array[--numElements];
        if(numElements <= this.array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public T peek() {
        return array[numElements - 1];
    }

    private void resize(int newSize) {
        T[] old = array;
        array = (T[]) new Object[newSize];
        System.arraycopy(old, 0, array, 0, numElements);
    }

    public void print() {
        for(int i = numElements - 1; i >= 0; --i) {
            System.out.println(array[i]);
        }
    }

    public int size() {
        return numElements;
    }
}
