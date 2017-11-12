package udemy.algo.trie;

public class TrieNode {
    private static final int SIZE = 26;

    private int key;
    private Integer value;
    private TrieNode[] children;
    private boolean visited;

    @SuppressWarnings("unchecked")
    public TrieNode(int key, Integer value) {
        this.key = key;
        this.value = value;
        this.children = new TrieNode[SIZE];
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isLeaf() {
        return this.value != null;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public TrieNode getOrInsert(int index, int key) {
        TrieNode node = this.children[index];
        if(node == null) {
            node = new TrieNode(key, null);
            this.children[index] = node;
        }
        return node;
    }

    public TrieNode get(int index) {
        return this.children[index];
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return Integer.toString(this.key);
    }
}
