package udemy.algo.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class LinkedListTest extends Assertions {
    @Test
    public void testList() {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("Cenk");
        list.addFirst("ali");
        assertThat(list.head()).isEqualTo("ali");

        list.addLast("hasan");
        assertThat(list.head()).isEqualTo("ali");

        list.removeFirst();
        assertThat(list.head()).isEqualTo("Cenk");

        list.addFirst("veli");
        list.addFirst("cemal");
        list.remove("ali");
    }
}
