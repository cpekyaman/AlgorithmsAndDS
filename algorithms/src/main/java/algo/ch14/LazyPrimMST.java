package algo.ch14;

import algo.ch12.Graph;
import algo.graph.Edge;

import java.util.*;

public final class LazyPrimMST implements MST {
    private final Graph graph;
    private final List<Edge> mst;

    public LazyPrimMST(Graph graph) {
        this.graph = graph;
        this.mst = new LinkedList<>();
        buildMST();
    }

    private void buildMST() {
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        Set<Integer> visited = new HashSet<>(graph.size());

        visitVertex(0, edges, visited);

        while(! edges.isEmpty()) {
            Edge e = edges.remove();

            Integer v = e.getV().getId();
            Integer w = e.getW().getId();
            if(visited.contains(v) && visited.contains(w)){
                continue;
            }

            mst.add(e);

            if(! visited.contains(v)) {
                visitVertex(v, edges, visited);
            }
            if(! visited.contains(w)) {
                visitVertex(w, edges, visited);
            }
        }
    }

    private void visitVertex(Integer v, Queue<Edge> edges, Set<Integer> visited) {
        visited.add(v);
        graph.adjacents(v).stream()
             .filter(e -> ! visited.contains(e.other(v).getId()))
             .forEach(edges::add);
    }

    @Override
    public List<Edge> edges() {
        return mst;
    }
}
