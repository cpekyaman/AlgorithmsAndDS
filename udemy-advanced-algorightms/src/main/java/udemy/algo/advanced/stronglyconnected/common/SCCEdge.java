package udemy.algo.advanced.stronglyconnected.common;

import java.util.Objects;

public class SCCEdge<T extends SCCVertex> implements Comparable<SCCEdge> {
    private final T start;
    private final T end;
    private final double weight;

    public SCCEdge(T start, T end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SCCEdge that = (SCCEdge) o;
        return Objects.equals(start, that.start) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(SCCEdge o) {
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
