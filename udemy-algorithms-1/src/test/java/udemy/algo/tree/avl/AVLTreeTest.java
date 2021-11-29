package udemy.algo.tree.avl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.algo.tree.Tree;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class AVLTreeTest {
    private Tree<Integer> tree;
    private Consumer<Integer> intPrinter;

    @BeforeEach
    public void setup() {
        tree = new AVLTree<>();
        intPrinter = i -> System.out.printf("%d ", i);
    }

    @Test
    public void testLeftHeavy() {
        Stream.of(1,2,3).forEach(tree::insert);
        tree.traverse(intPrinter);
        System.out.println();
    }

    @Test
    public void testRightHeavy() {
        Stream.of(3,2,1).forEach(tree::insert);
        tree.traverse(intPrinter);
        System.out.println();
    }

    @Test
    public void testLeftRight() {
        Stream.of(3,1,2).forEach(tree::insert);
        tree.traverse(intPrinter);
        System.out.println();
    }
}
