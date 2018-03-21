package udemy.algo.advanced.shortestpath;

import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

import java.util.List;

public class BellmanFord implements ShortestPath {
    private final List<SPVertex> vertices;
    private final List<SPEdge> edges;

    public BellmanFord(List<SPVertex> vertices, List<SPEdge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public void compute(SPVertex source) {
        source.setDistance(0.0D);

        for (int i = 0; i < vertices.size() - 1; i++) {
            for(SPEdge edge : edges) {
                SPVertex u = edge.getFrom();
                if(u.getDistance() == Double.MAX_VALUE) {
                    continue;
                }
                calculateDistance(edge, null);
            }
        }

        for(SPEdge edge : edges) {
            if(edge.getFrom().getDistance() != Double.MAX_VALUE) {
                if(hasCycle(edge)) {
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(SPEdge edge) {
        return edge.getFrom().getDistance() + edge.getWeight() < edge.getTo().getDistance();
    }
}
