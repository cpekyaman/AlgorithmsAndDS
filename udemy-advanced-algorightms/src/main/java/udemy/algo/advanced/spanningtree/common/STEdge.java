package udemy.algo.advanced.spanningtree.common;

import java.util.Objects;

public class STEdge<T extends STVertex> implements Comparable<STEdge> {
    private final T start;
    private final T end;
    private final double weight;

    public STEdge(T start, T end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STEdge that = (STEdge) o;
        return Objects.equals(start, that.start) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(STEdge o) {
        return Double.compare(weight, o.weight);
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "( " + start.toString() + " -> " + this.weight + " -> " + end.toString() + " )";
    }
}
