package algo.ch08;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest extends Assertions {

    @Test
    void getShouldReturnNullIfTreeIsEmpty() {
        assertThat(new BinarySearchTree<String, Integer>().get("nope")).isNull();
    }

    @Test
    void getShouldBeAbleToFindExistingItems() {
        // given
        BinarySearchTree<String, Integer> tree = new BinarySearchTree<>();

        // when
        tree.insert("H", 2)
            .insert("C", 7)
            .insert("S", 5)
            .insert("A", 4)
            .insert("E", 9)
            .insert("R", 1)
            .insert("X", 6);

        // then
        assertThat(tree.get("H")).isEqualTo(2);
        assertThat(tree.get("E")).isEqualTo(9);
        assertThat(tree.get("Z")).isNull();
    }

    @Test
    void keysShouldIterateKeysInNaturalOrder() {
        // given
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

        // when
        tree.insert(4, "cenk")
            .insert(2, "alex")
            .insert(5, "jack")
            .insert(9, "john")
            .insert(7, "bob")
            .insert(6, "hank");

        // then
        assertThat(tree.keys()).containsExactly(2, 4, 5, 6, 7, 9);
    }

    @Test
    void maxShouldReturnValueOfRightMostKey() {
        // given
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

        // when
        tree.insert(4, "cenk")
            .insert(2, "alex")
            .insert(5, "jack")
            .insert(9, "john")
            .insert(7, "bob")
            .insert(6, "hank");

        // then
        assertThat(tree.max()).isEqualTo("john");
    }

    @Test
    void minShouldReturnValueOfLeftMostKey() {
        // given
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

        // when
        tree.insert(4, "cenk")
            .insert(2, "alex")
            .insert(5, "jack")
            .insert(9, "john")
            .insert(7, "bob")
            .insert(6, "hank");

        // then
        assertThat(tree.min()).isEqualTo("alex");
    }

    @Test
    void deleteShouldBeAbleToRemoveAnyItem() {
        // given
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

        tree.insert(4, "cenk")
            .insert(2, "alex")
            .insert(5, "jack")
            .insert(9, "john")
            .insert(7, "bob")
            .insert(6, "hank");

        assertThat(tree.max()).isEqualTo("john");

        // when
        tree.delete(9);
        // then
        assertThat(tree.max()).isEqualTo("bob");

        // and
        tree.delete(7);
        // then
        assertThat(tree.get(7)).isNull();
    }
}