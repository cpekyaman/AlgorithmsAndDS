package udemy.algo.compression.huffman;

import java.util.PriorityQueue;

public class Huffman {
    public HuffmanTree build(int[] charFrequencies) {
        PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();

        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] > 0) {
                queue.add(new HuffmanLeaf(charFrequencies[i], (char) i));
            }
        }

        while(queue.size() > 1) {
            HuffmanTree left = queue.poll();
            HuffmanTree right = queue.poll();
            queue.add(new HuffmanNode(left, right));
        }

        return queue.poll();
    }

    public void printCodes(HuffmanTree tree, StringBuilder prefix) {
        if(tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.printf("%c\t%d\t%s\n", leaf.getValue(), leaf.getFrequency(), prefix);
        } else {
            HuffmanNode node = (HuffmanNode) tree;

            prefix.append("0");
            printCodes(node.getLeft(), prefix);
            // required to remove excess char from last iteration
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            printCodes(node.getRight(), prefix);
            // required to remove excess char from last iteration
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
