package algo.ch09;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest extends Assertions {

    @Test
    void shouldBeAbleToInsertAndTraverseWithIntegers() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.insert(13, "alex")
            .insert(9, "john")
            .insert(15, "jack")
            .insert(7, "sarah")
            .insert(5, "alice")
            .insert(6, "bill")
            .insert(2, "bob")
            .insert(17, "hank");

        // then
        tree.traverse(System.out::println);
    }

    @Test
    void shouldBeAbleToInsertAndTraverseWithChars() {
        // given
        RedBlackTree<Character, Integer> tree = new RedBlackTree<>();

        // when
        tree.insert('S', 13)
            .insert('E', 9)
            .insert('A', 15)
            .insert('R', 7)
            .insert('C', 5)
            .insert('H', 6)
            .insert('X', 2)
            .insert('M', 17);

        // then
        tree.traverse(System.out::println);
    }
}