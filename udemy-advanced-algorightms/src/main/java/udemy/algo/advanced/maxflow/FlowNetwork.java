package udemy.algo.advanced.maxflow;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private final int numVertices;
    private final List<List<FlowEdge>> adjacencies;
    private int numEdges;

    public FlowNetwork(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencies = new ArrayList<>();
        this.numEdges = 0;

        for (int i = 0; i < numVertices; i++) {
            adjacencies.add(new ArrayList<>());
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void addEdge(FlowEdge edge) {
        this.adjacencies.get(edge.getSource().getId()).add(edge);
        this.adjacencies.get(edge.getTarget().getId()).add(edge);
        numEdges++;
    }

    public List<FlowEdge> getAdjacencies(FlowVertex vertex) {
        return this.adjacencies.get(vertex.getId());
    }
}
