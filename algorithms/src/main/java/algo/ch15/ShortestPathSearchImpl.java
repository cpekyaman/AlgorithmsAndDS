package algo.ch15;

import algo.ch13.Digraph;
import algo.graph.Edge;

import java.util.*;

abstract class ShortestPathSearchImpl implements ShortestPathSearch {
    protected final Digraph graph;
    protected final Integer from;

    protected final Map<Integer, Edge> edges;
    protected final Map<Integer, Integer> distances;

    protected ShortestPathSearchImpl(Digraph graph, Integer from) {
        this.graph = graph;
        this.from = from;

        this.edges = new HashMap<>();
        this.distances = new HashMap<>();
    }

    @Override
    public List<Edge> pathTo(Integer to) {
        // or use a stack and return an iterable
        List<Edge> shortestPath = new ArrayList<>();
        // start from edge to last vertex and move to other direction (to -> from)
        for(Edge edge = edges.get(to); edge != null; edge = edges.get(edge.getV().getId())) {
            shortestPath.add(edge);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    @Override
    public boolean hasPathTo(Integer to) {
        return distances.get(to) < Integer.MAX_VALUE;
    }

    protected void relax(Edge edge) {
        Integer wDistance = distances.computeIfAbsent(edge.getW().getId(), w -> Integer.MAX_VALUE);
        // no need for computeIfAbsent as we move from vertex to vertex by calculating distance
        int vDistance = distances.get(edge.getV().getId()) + edge.getWeight();

        if(wDistance > vDistance) {
            edges.put(edge.getW().getId(), edge);
            distances.put(edge.getW().getId(), vDistance);
            relaxEdgeUpdate(edge, vDistance);
        }
    }

    protected abstract void relaxEdgeUpdate(Edge edge, int newDistance);
}
