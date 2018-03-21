package udemy.algo.advanced.stronglyconnected.tarjan;

import udemy.algo.advanced.stronglyconnected.common.SCCVertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TarjanVertex implements SCCVertex<TarjanVertex> {
    private final String name;
    private TarjanVertex predecessor;
    private int lowLink;
    private boolean visited;
    private List<TarjanVertex> neighbours;

    public TarjanVertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void markVisited() {
        this.visited = true;
    }

    public int getLowLink() {
        return lowLink;
    }

    public void setLowLink(int lowLink) {
        this.lowLink = lowLink;
    }

    public List<TarjanVertex> getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjanVertex that = (TarjanVertex) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public void addNeighbour(TarjanVertex vertex) {
        this.neighbours.add(vertex);
    }
}
