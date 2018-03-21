package udemy.algo.advanced.shortestpath.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SPVertex implements Comparable<SPVertex> {
    private final String name;
    private final List<SPEdge> neighbours;

    private boolean visited;
    private SPVertex predecessor;
    private double distance = Double.MAX_VALUE;

    public SPVertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SPVertex spVertex = (SPVertex) o;
        return Objects.equals(name, spVertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(SPVertex o) {
        return Double.compare(this.distance, o.distance);
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<SPEdge> getNeighbours() {
        return neighbours;
    }

    public double getDistance() {
        return distance;
    }

    public void setPredecessor(SPVertex predecessor) {
        this.predecessor = predecessor;
    }

    public SPVertex getPredecessor() {
        return predecessor;
    }

    public void addNeighbour(SPEdge spEdge) {
        this.neighbours.add(spEdge);
    }

    @Override
    public String toString() {
        return name;
    }
}
