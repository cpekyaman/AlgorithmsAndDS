package udemy.algo.advanced.spanningtree.prim;

import udemy.algo.advanced.spanningtree.common.STEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class LazyPrim {
    private Set<LazyPrimVertex> notVisited;
    private List<STEdge<LazyPrimVertex>> tree;
    private PriorityQueue<STEdge<LazyPrimVertex>> edgeHeap;
    private double fullCost = 0.0;

    public LazyPrim(Set<LazyPrimVertex> notVisited) {
        this.notVisited = notVisited;
        this.edgeHeap = new PriorityQueue<>();
        this.tree = new ArrayList<>();
    }

    public void mst(LazyPrimVertex vertex) {
        this.notVisited.remove(vertex);

        while(! this.notVisited.isEmpty()) {
            edgeHeap.addAll(vertex.getAdjacents()
                    .stream()
                    .filter(e -> notVisited.contains(e.getEnd()))
                    .collect(Collectors.toList()));

            STEdge<LazyPrimVertex> minEdge = edgeHeap.remove();

            this.tree.add(minEdge);
            this.fullCost += minEdge.getWeight();

            vertex = minEdge.getEnd();
            this.notVisited.remove(vertex);
        }
    }

    public void show() {
        System.out.println("Full cost is " + fullCost);
        System.out.println(tree);
    }
}
