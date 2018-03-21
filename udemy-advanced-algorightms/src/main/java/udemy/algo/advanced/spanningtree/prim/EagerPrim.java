package udemy.algo.advanced.spanningtree.prim;

import udemy.algo.advanced.spanningtree.common.NonDirectedGraph;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class EagerPrim {
    private Set<EagerPrimVertex> vertices;
    private PriorityQueue<EagerPrimVertex> heap;

    public EagerPrim(NonDirectedGraph<EagerPrimVertex> graph) {
        this.vertices = graph.getVertices();
        this.heap = new PriorityQueue<>();
    }

    public void mst() {
        this.vertices.stream().filter(v -> !v.isVisited()).forEach(this::makePrimJarnik);
    }

    private void makePrimJarnik(EagerPrimVertex vertex) {
        vertex.setDistance(0.0);
        heap.add(vertex);

        while (!heap.isEmpty()) {
            scanVertices(heap.remove());
        }
    }

    private void scanVertices(EagerPrimVertex vertex) {
        vertex.markVisited();

        vertex.getAdjacents().stream()
                .filter(e -> !e.getEnd().isVisited())
                .filter(e -> e.getWeight() < e.getEnd().getDistance())
                .forEach(e -> {
                    e.getEnd().setDistance(e.getWeight());
                    e.getEnd().setMinimumEdge(e);

                    this.heap.remove(e.getEnd());
                    this.heap.add(e.getEnd());
                });
    }

    public void show() {
        this.vertices.stream()
                .map(EagerPrimVertex::getMinimumEdge)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
