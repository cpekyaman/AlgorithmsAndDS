package udemy.algo.lists;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raistlin on 9/24/2017.
 */
public class LinkedListTest {
    @Test
    public void testList() {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("Cenk");
        list.addFirst("ali");
        Assert.assertSame("ali", list.head());

        list.addLast("hasan");
        Assert.assertSame("ali", list.head());

        list.removeFirst();
        Assert.assertSame("Cenk", list.head());

        list.addFirst("veli");
        list.addFirst("cemal");
        list.remove("ali");
    }
}
