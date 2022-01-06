package algo.ch15;

import algo.ch13.Digraph;
import algo.graph.Edge;

import java.util.Objects;
import java.util.PriorityQueue;

public final class DijkstraShortestPathSearch extends ShortestPathSearchImpl {

    private final PriorityQueue<VertexDistance> queue;

    public DijkstraShortestPathSearch(Digraph graph, Integer from) {
        super(graph, from);
        if(graph.edges().stream().anyMatch(e -> e.getWeight() < 0)) {
            throw new IllegalArgumentException("graph has negative weighted edges");
        }
        this.queue = new PriorityQueue<>();
        processGraph();
    }

    private void processGraph() {
        distances.put(from, 0);
        queue.offer(new VertexDistance(from, 0));

        while(! queue.isEmpty()) {
            Integer v = queue.remove().vertex;
            graph.adjacents(v).forEach(this::relax);
        }
    }

    private void relax(Edge edge) {
        Integer wDistance = distances.computeIfAbsent(edge.getW().getId(), w -> Integer.MAX_VALUE);
        // no need for computeIfAbsent as we move from vertex to vertex by calculating distance
        int vDistance = distances.get(edge.getV().getId()) + edge.getWeight();

        if(wDistance > vDistance) {
            edges.put(edge.getW().getId(), edge);
            distances.put(edge.getW().getId(), vDistance);
            VertexDistance wd = new VertexDistance(edge.getW().getId(), vDistance);
            queue.remove(wd);
            queue.offer(wd);
        }
    }

    // equals / hashCode only consider vertexId to make it easy to manage removal of items
    private static final class VertexDistance implements Comparable<VertexDistance> {
        private final Integer vertex;
        private final Integer distance;

        public VertexDistance(Integer vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance o) {
            return Integer.compare(distance, o.distance);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VertexDistance that = (VertexDistance) o;
            return vertex.equals(that.vertex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex);
        }
    }
}
