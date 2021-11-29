package udemy.algo.tree.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.algo.tree.Tree;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchTreeTest {

    private Consumer<Integer> intPrinter;

    @BeforeEach
    public void setup() {
        intPrinter = i -> System.out.printf("%d ", i);
    }

    @Test
    public void testTreeInsert() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(15);
        tree.insert(7);
        tree.insert(12);
        tree.insert(1);
        tree.insert(25);
        tree.insert(-6);

        tree.traverse(intPrinter);
        System.out.println();
    }

    @Test
    public void testTreeMinMax() {
        Tree<Integer> tree = new BinarySearchTree<>();

        final Random rand = new Random();
        IntStream.generate(() -> rand.nextInt(100)).limit(20).forEach(tree::insert);

        System.out.printf("Min: %d\n", tree.getMin());
        System.out.printf("Max: %d\n", tree.getMax());
    }

    @Test
    public void testRemoveLeaf() {
        Tree<Integer> tree = new BinarySearchTree<>();

        List<Integer> data = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(data);

        System.out.println("Data =>");
        data.forEach(intPrinter);
        System.out.println();
        data.forEach(tree::insert);

        System.out.println("Traverse =>");
        tree.traverse(intPrinter);
        System.out.println();

        System.out.println("Delete 10 =>");
        tree.delete(10);
        tree.traverse(intPrinter);
        System.out.println();

        System.out.println("Delete 1 =>");
        tree.delete(1);
        tree.traverse(intPrinter);
        System.out.println();
    }
}
