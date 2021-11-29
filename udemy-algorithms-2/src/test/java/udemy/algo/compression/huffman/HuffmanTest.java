package udemy.algo.compression.huffman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HuffmanTest {
    private Huffman huffman;
    private int[] charFrequencies;

    @BeforeEach
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
