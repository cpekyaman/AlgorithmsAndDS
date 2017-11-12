package udemy.algo.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Trie {
    private static final int ASCII_BASE = (int) 'a';

    private TrieNode tree;

    public Trie() {
        this.tree = new TrieNode(0, null);
    }

    public void insert(String key, Integer value) {
        TrieNode node = findNode(key);
        node.setValue(value);
    }

    private TrieNode findNode(String key) {
        TrieNode node = tree;
        for(char c : toChars(key)) {
            if(node == null) {
                break;
            }
            int index = (int) c - ASCII_BASE;
            node = node.getOrInsert(index, c);
        }
        return node;
    }

    public Integer search(String key) {
        TrieNode node = findNode(key);
        return node != null ? node.getValue() : null;
    }

    private char[] toChars(String key) {
        return key.toLowerCase(Locale.US).toCharArray();
    }

    public List<String> autocomplete(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode prefixNode = findNode(prefix);
        collect(prefixNode, prefix, suggestions);
        return suggestions;
    }

    public List<String> sortedList() {
        List<String> sorted = new ArrayList<>();
        collect(tree, "", sorted);
        return sorted;
    }

    public String longestCommonPrefix() {
        String prefix = "";
        TrieNode node = tree;
        // TODO: implement
        // include key of all nodes with only single non-null child
        return prefix;
    }

    private void collect(TrieNode root, String prefix, List<String> suggestions) {
        if(root == null) {
            return;
        }
        if(root.isLeaf()) {
            suggestions.add(prefix);
        }

        for(TrieNode node : root.getChildren()) {
            if(node != null) {
                collect(node, prefix + (char) node.getKey(), suggestions);
            }
        }
    }
}
