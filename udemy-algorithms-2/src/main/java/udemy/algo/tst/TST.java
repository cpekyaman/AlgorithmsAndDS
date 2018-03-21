package udemy.algo.tst;

public class TST {
    private TSTNode root;

    public void put(String key, Integer value) {
        this.root = this.put(this.root, key, value, 0);
    }

    private TSTNode put(TSTNode node, String key, Integer value, int index) {
        char c = key.charAt(index);

        TSTNode currentNode = node;
        if (currentNode == null) {
            currentNode = new TSTNode(c);
        }

        if(c < currentNode.getKey()) {
            currentNode.setLeft(put(currentNode.getLeft(), key, value, index));
        } else if(c > currentNode.getKey()) {
            currentNode.setRight(put(currentNode.getRight(), key, value, index));
        } else if(index < key.length() - 1) {
            currentNode.setMiddle(put(currentNode.getMiddle(), key, value, index + 1));
        } else {
            currentNode.setValue(value);
        }

        return currentNode;
    }

    public Integer get(String key) {
        TSTNode node = get(root, key, 0);
        return node != null ? node.getValue() : null;
    }

    private TSTNode get(TSTNode node, String key, int index) {
        if (node == null) {
            return null;
        }

        char c = key.charAt(index);

        if(c < node.getKey()) {
            return get(node.getLeft(), key, index);
        } else if(c > node.getKey()) {
            return get(node.getRight(), key, index);
        } else if(index < key.length() - 1) {
            return get(node.getMiddle(), key, index + 1);
        } else {
            return node;
        }
    }
}
