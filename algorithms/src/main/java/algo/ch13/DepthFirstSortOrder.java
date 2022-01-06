package algo.ch13;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.*;

public final class DepthFirstSortOrder implements GraphSortOrder {
    private final Digraph graph;
    private final Set<Integer> visited;

    private final List<Integer> postOrder;
    private final List<Integer> reversePostOrder;

    public DepthFirstSortOrder(Digraph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();

        this.postOrder = new LinkedList<>();
        this.reversePostOrder = new LinkedList<>();

        dfs();
    }

    private void dfs() {
        for(Vertex v : this.graph.vertices()) {
            if(! visited.contains(v.getId())) {
                dfs(v);
            }
        }
        for (int i = postOrder.size() - 1; i >= 0; i--) {
            reversePostOrder.add(postOrder.get(i));
        }
    }

    private void dfs(Vertex v) {
        visited.add(v.getId());

        for(Edge adj : graph.adjacents(v.getId())) {
            Vertex other = adj.other(v);
            if(! visited.contains(other.getId())) {
                dfs(other);
            }
        }
        postOrder.add(v.getId());
    }

    @Override
    public List<Integer> reversePost() {
        return reversePostOrder;
    }
}
