package algo.ch18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TrieTest extends Assertions {

    @ParameterizedTest
    @MethodSource("trieDataSet")
    void emptyTrieShouldReturnNullForGet(Trie<String, Integer> trie) {
        assertThat(trie.get("test")).isNull();
    }

    @ParameterizedTest
    @MethodSource("trieDataSet")
    void shouldBeAbleToGetWhatWasPut(Trie<String, Integer> trie) {
        // when
        trie.put("cenk", 5);

        // then
        assertThat(trie.get("cenk")).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("trieDataSet")
    void shouldReturnAfterAKeyIsRemoved(Trie<String, Integer> trie) {
        // when
        trie.put("cenk", 5);
        // then
        assertThat(trie.get("cenk")).isEqualTo(5);

        // and
        trie.delete("cenk");
        // then
        assertThat(trie.get("cenk")).isNull();
    }

    @ParameterizedTest
    @MethodSource("trieDataSet")
    void shouldBeAbleToIterateAndReturnAllKeys(Trie<String, Integer> trie) {
        // given
        fillTrie(trie);

        // when / then
        assertThat(trie.keys())
                .containsExactlyInAnyOrder("sea", "she", "shell", "seam", "be", "begin", "bells")
                .doesNotContain("se", "beg");
    }

    @ParameterizedTest
    @MethodSource("trieDataSet")
    void shouldBeAbleToFindKeysWithPrefix(Trie<String, Integer> trie) {
        // given
        fillTrie(trie);

        // when / then
        assertThat(trie.keysWithPrefix("be"))
                .containsExactlyInAnyOrder("be", "begin", "bells")
                .doesNotContain("bel", "beg", "bell");
    }

    private void fillTrie(Trie<String, Integer> trie) {
        trie.put("sea", 5);
        trie.put("she", 8);
        trie.put("shell", 3);
        trie.put("seam", 2);

        trie.put("be", 9);
        trie.put("begin", 1);
        trie.put("bells", 4);
    }

    static Stream<Trie<String, Integer>> trieDataSet() {
        return Stream.of(new StringRWayTrie<>(), new StringTernarySearchTrie<>());
    }
}