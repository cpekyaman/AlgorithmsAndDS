package udemy.algo.advanced.shortestpath;

import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public interface ShortestPath {
    void compute(SPVertex source);

    default List<SPVertex> getShortestPathTo(SPVertex target) {
        if(target.getDistance() == Double.MAX_VALUE) {
            System.out.println("No Path Found");
            return Collections.emptyList();
        }

        List<SPVertex> shortestPath = new ArrayList<>();
        for(SPVertex vertex = target; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPath.add(vertex);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    default void calculateDistance(SPEdge edge, Consumer<SPVertex> c) {
        SPVertex u = edge.getFrom();
        SPVertex v = edge.getTo();

        double distance = u.getDistance() + edge.getWeight();

        if(distance < v.getDistance()) {
            v.setDistance(distance);
            v.setPredecessor(u);
            if(c != null) {
                c.accept(v);
            }
        }
    }
}
