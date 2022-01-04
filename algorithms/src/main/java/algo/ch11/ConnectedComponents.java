package algo.ch11;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ConnectedComponents {
    private final Graph graph;

    private final Set<Integer> visited;
    private final Map<Integer, Integer> componentIds;

    public ConnectedComponents(Graph graph) {
        this.graph = graph;
        this.visited = new HashSet<>(graph.size());
        this.componentIds = new HashMap<>(graph.size());
        this.processGraph();
    }

    public Integer componentId(Integer v) {
        return componentIds.get(v);
    }

    private void processGraph() {
        int id = 1;

        for(Vertex v : graph.vertices()) {
            if(! visited.contains(v.getId())) {
                dfs(v.getId(), id);
                id++;
            }
        }
    }

    private void dfs(Integer v, int componentId) {
        visited.add(v);
        componentIds.put(v, componentId);

        for(Edge edge : graph.adjacents(v)) {
            Integer target = edge.getW().getId();
            if(! visited.contains(target)) {
                dfs(target, componentId);
            }
        }
    }
}
