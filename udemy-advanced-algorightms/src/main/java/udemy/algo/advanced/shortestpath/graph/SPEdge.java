package udemy.algo.advanced.shortestpath.graph;

public class SPEdge {
    private final double weight;
    private final SPVertex from;
    private final SPVertex to;

    public SPEdge(double weight, SPVertex from, SPVertex to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public double getWeight() {
        return weight;
    }

    public SPVertex getFrom() {
        return from;
    }

    public SPVertex getTo() {
        return to;
    }
}
