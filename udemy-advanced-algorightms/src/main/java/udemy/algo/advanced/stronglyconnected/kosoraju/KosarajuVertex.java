package udemy.algo.advanced.stronglyconnected.kosoraju;

import udemy.algo.advanced.stronglyconnected.common.SCCVertex;

import java.util.ArrayList;
import java.util.List;

public class KosarajuVertex implements SCCVertex<KosarajuVertex> {
    private final int id;
    private final String name;
    private boolean visited;
    private int componentId;

    private List<KosarajuVertex> neighbours;

    public KosarajuVertex(int id, String name) {
        this.id = id;
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    @Override
    public void addNeighbour(KosarajuVertex vertex) {
        this.neighbours.add(vertex);
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<KosarajuVertex> getNeighbours() {
        return neighbours;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
