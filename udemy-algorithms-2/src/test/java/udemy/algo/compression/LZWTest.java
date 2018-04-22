package udemy.algo.compression;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LZWTest {
    private LZW lzw;

    @Before
    public void setup() {
        lzw = new LZW();
    }

    @Test
    public void testLZW() {
        List<Integer> compressed = lzw.compress("CARRARCARCAR");
        System.out.println(compressed);
    }
}
