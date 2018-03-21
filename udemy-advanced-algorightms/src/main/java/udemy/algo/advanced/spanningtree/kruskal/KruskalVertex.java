package udemy.algo.advanced.spanningtree.kruskal;

import udemy.algo.advanced.spanningtree.common.STVertex;
import udemy.algo.advanced.spanningtree.djset.DisjointNode;

import java.util.Objects;

public class KruskalVertex implements STVertex {
    private final String name;
    private DisjointNode node;

    public KruskalVertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KruskalVertex that = (KruskalVertex) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setNode(DisjointNode node) {
        this.node = node;
    }

    public DisjointNode getNode() {
        return node;
    }
}
