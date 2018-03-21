package udemy.algo.advanced.shortestpath;

import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

import java.util.List;
import java.util.Stack;

public class DAG implements ShortestPath {
    private final List<SPVertex> vertices;

    public DAG(List<SPVertex> vertices) {
        this.vertices = vertices;
    }

    @Override
    public void compute(SPVertex source) {
        source.setDistance(0.0D);

        //TODO: convert TopologicalOrdering to accept SPVertex
        /*TopologicalOrdering to = new TopologicalOrdering();
        to.order(source);
        Stack vertices = to.getVertices();*/
        Stack<SPVertex> orderedVertices = new Stack<>();

        for(SPVertex vertex : orderedVertices) {
            for(SPEdge edge : vertex.getNeighbours()) {
                calculateDistance(edge, null);
            }
        }
    }

    @Override
    public List<SPVertex> getShortestPathTo(SPVertex target) {
        return null;
    }
}
