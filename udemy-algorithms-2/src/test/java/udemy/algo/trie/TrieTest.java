package udemy.algo.trie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrieTest extends Assertions {
    private Trie trie;

    @BeforeEach
    public void setup() {
        trie = new Trie();
    }

    @Test
    public void testInsertAndSearch() {
        // given
        trie.insert("Joe", 5);
        trie.insert("Joan", 8);
        trie.insert("Joel", 9);
        trie.insert("Adamovich", 2);
        trie.insert("Helloworld", 4);

        trie.insert("adam", 22);
        trie.insert("adamm", 33);

        // then
        assertThat(trie.search("joel")).isEqualTo(9);
        assertThat(trie.search("adamovic")).isNull();
        assertThat(trie.search("Adamovich")).isEqualTo(2);
        assertThat(trie.search("doesnotexist")).isNull();

        assertThat(trie.search("adam")).isEqualTo(22);
        assertThat(trie.search("adamm")).isEqualTo(33);
    }

    @Test
    public void testAutocomplete() {
        // given
        trie.insert("adam", 1);
        trie.insert("adamo", 2);
        trie.insert("ahoy", 3);
        trie.insert("hello",5);
        trie.insert("helloworld",7);

        // then
        assertThat(trie.autocomplete("ad")).containsOnly("adam", "adamo").hasSize(2);
        assertThat(trie.autocomplete("hel")).containsOnly("hello", "helloworld").hasSize(2);

    }

    @Test
    public void testSort() {
        // given
        trie.insert("cenk", 3);
        trie.insert("adam", 1);
        trie.insert("hello", 2);
        trie.insert("joel", 3);
        trie.insert("evelyn", 5);

        // when
        List<String> sorted = trie.sortedList();

        // then
        assertThat(sorted.get(0)).isEqualTo("adam");
        assertThat(sorted.get(sorted.size() - 1)).isEqualTo("joel");

    }
}
