package udemy.algo.compression.huffman;

import org.junit.Before;
import org.junit.Test;

public class HuffmanTest {
    private Huffman huffman;
    private int[] charFrequencies;

    @Before
    public void setup() {
        String text = "My name is joyiii";

        charFrequencies = new int[256];
        for (char c : text.toCharArray()) {
            charFrequencies[c]++;
        }

        huffman = new Huffman();
    }

    @Test
    public void testHuffman() {
        HuffmanTree huffmanTree = huffman.build(charFrequencies);

        huffman.printCodes(huffmanTree, new StringBuilder());
    }
}
