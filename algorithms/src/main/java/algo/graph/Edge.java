package algo.graph;

import java.util.Comparator;

// equality of directed vs undirected edge is a little different, that's the main reason we have subclasses here.
// directed-ness is mainly managed by adjacent lists of vertices.
public abstract class Edge implements Comparable<Edge> {
    protected final Vertex V;
    protected final Vertex W;
    protected final int weight;

    public Edge(Vertex V, Vertex W) {
        this(V, W, 1);
    }

    public Edge(Vertex V, Vertex W, int weight) {
        this.V = V;
        this.W = W;
        this.weight = weight;
    }

    public Vertex getV() {
        return V;
    }

    public Vertex getW() {
        return W;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex other(Integer me) {
        return me.equals(V.getId()) ? W : V;
    }

    public Vertex other(Vertex me) {
        return me.equals(V) ? W : V;
    }

    @Override
    public String toString() {
        return String.format("Edge(%d, %d, %d)", V.getId(), W.getId(), weight);
    }

    @Override
    public int compareTo(Edge o) {
        return Comparator.comparingInt(Edge::getWeight).compare(this, o);
    }
}
