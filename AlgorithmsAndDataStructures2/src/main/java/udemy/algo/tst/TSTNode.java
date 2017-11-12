package udemy.algo.tst;

public class TSTNode {
    private int key;
    private Integer value;

    private TSTNode left;
    private TSTNode middle;
    private TSTNode right;

    public TSTNode(int key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TSTNode getLeft() {
        return left;
    }

    public void setLeft(TSTNode left) {
        this.left = left;
    }

    public TSTNode getMiddle() {
        return middle;
    }

    public void setMiddle(TSTNode middle) {
        this.middle = middle;
    }

    public TSTNode getRight() {
        return right;
    }

    public void setRight(TSTNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }
}
