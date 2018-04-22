package udemy.algo.compression.huffman;

public class HuffmanTree implements Comparable<HuffmanTree> {
    private final int frequency;

    public HuffmanTree(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return Integer.compare(this.frequency, o.frequency);
    }

    public int getFrequency() {
        return frequency;
    }
}
