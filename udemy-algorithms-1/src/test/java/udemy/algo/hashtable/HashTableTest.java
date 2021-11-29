package udemy.algo.hashtable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class HashTableTest extends Assertions {

    private Hashtable<String, Integer> table;

    @BeforeEach
    public void setup() {
        table = new Hashtable<>(20);
    }

    @Test
    public void testConstructor() {
        assertThat(table.size()).isZero();
        assertThat(table.isEmpty()).isTrue();
    }

    @Test
    public void testGet() {
        // given
        sampleData();

        // then
        assertThat(table.size()).isEqualTo(3);
        assertThat(table.get("cenk")).isEqualTo(37);

        // when
        table.put("cenk", 40);
        // then
        assertThat(table.size()).isEqualTo(3);
        assertThat(table.get("cenk")).isEqualTo(40);

    }

    private void sampleData() {
        table.put("cenk", 37);
        table.put("selime", 35);
        table.put("hilal", 34);
    }

    @Test
    public void testDelete() {
        // given
        sampleData();
        assertThat(table.size()).isEqualTo(3);
        Integer expected = table.get("cenk");

        // when
        Integer removed = table.remove("cenk");

        // then
        assertThat(table.size()).isEqualTo(2);
        assertThat(removed).isEqualTo(expected);
    }
}
