package udemy.algo.advanced.spanningtree.djset;

import udemy.algo.advanced.spanningtree.kruskal.KruskalVertex;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private int nodeCount;
    private int setCount;
    private List<DisjointNode> rootNodes;

    public DisjointSet(List<KruskalVertex> vertices) {
        this.rootNodes = new ArrayList<>(vertices.size());
        makeSets(vertices);
    }

    public int find(DisjointNode node) {
        DisjointNode current = node;
        while (current.getParent() != null) {
            current = current.getParent();
        }

        DisjointNode rootNode = current;

        current = node;
        while (current != rootNode) {
            DisjointNode temp = current.getParent();
            current.setParent(rootNode);
            current = temp;
        }

        return rootNode.getId();
    }

    public boolean areInSameSet(KruskalVertex firstVertex, KruskalVertex secondVertex) {
        return this.find(firstVertex.getNode()) == this.find(secondVertex.getNode());
    }

    public void union(DisjointNode firstNode, DisjointNode secondNode) {
        int firstIndex = find(firstNode);
        int secondIndex = find(secondNode);

        if (firstIndex == secondIndex) {
            return;
        }

        DisjointNode firstRoot = this.rootNodes.get(firstIndex);
        DisjointNode secondRoot = this.rootNodes.get(secondIndex);

        if (firstRoot.compareTo(secondNode) < 0) {
            firstRoot.setParent(secondRoot);
        } else if (firstRoot.compareTo(secondNode) > 0) {
            secondRoot.setParent(firstRoot);
        } else {
            secondRoot.setParent(firstRoot);
            firstRoot.incrementRank();
        }

        this.setCount--;
    }

    private void makeSets(List<KruskalVertex> vertices) {
        for (KruskalVertex vertex : vertices) {
            makeSet(vertex);
        }
    }

    private void makeSet(KruskalVertex vertex) {
        DisjointNode node = new DisjointNode(0, rootNodes.size(), null);
        vertex.setNode(node);

        this.rootNodes.add(node);
        this.setCount++;
        this.nodeCount++;
    }
}
