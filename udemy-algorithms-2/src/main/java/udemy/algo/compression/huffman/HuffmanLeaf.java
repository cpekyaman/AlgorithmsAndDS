package udemy.algo.compression.huffman;

public class HuffmanLeaf extends HuffmanTree {
    private final char value;

    public HuffmanLeaf(int frequency, char value) {
        super(frequency);
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
