package udemy.algo.advanced.spanningtree.djset;

import java.util.Objects;

public class DisjointNode implements Comparable<DisjointNode> {
    private int id;
    private int rank;
    private DisjointNode parent;

    public DisjointNode(int id, int rank, DisjointNode parent) {
        this.id = id;
        this.rank = rank;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public boolean isRoot() {
        return this.parent == this;
    }

    public DisjointNode getParent() {
        return parent;
    }

    public void setParent(DisjointNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisjointNode that = (DisjointNode) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(DisjointNode o) {
        return Integer.compare(this.rank, o.rank);
    }

    public void incrementRank() {
        this.rank++;
    }
}
