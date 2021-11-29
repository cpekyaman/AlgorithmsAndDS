package udemy.algo.compression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LZWTest {
    private LZW lzw;

    @BeforeEach
    public void setup() {
        lzw = new LZW();
    }

    @Test
    public void testLZW() {
        List<Integer> compressed = lzw.compress("CARRARCARCAR");
        System.out.println(compressed);
    }
}
