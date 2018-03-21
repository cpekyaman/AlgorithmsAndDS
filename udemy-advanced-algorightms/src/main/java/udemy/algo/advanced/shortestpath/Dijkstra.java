package udemy.algo.advanced.shortestpath;

import udemy.algo.advanced.shortestpath.graph.SPEdge;
import udemy.algo.advanced.shortestpath.graph.SPVertex;

import java.util.PriorityQueue;

public class Dijkstra implements ShortestPath {
    @Override
    public void compute(SPVertex source) {
        source.setDistance(0.0D);

        PriorityQueue<SPVertex> queue = new PriorityQueue<>();
        queue.offer(source);

        while(! queue.isEmpty()) {
            for(SPEdge edge : queue.poll().getNeighbours()) {
                calculateDistance(edge, v -> {
                    queue.remove(v);
                    queue.add(v);
                });
            }
        }
    }
}
