package udemy.algo.advanced.stronglyconnected.kosoraju;

import udemy.algo.advanced.stronglyconnected.common.DirectedGraph;

public class Kosaraju {
    private int[] sccIds;
    private boolean[] markedVertices;
    private int count;

    public Kosaraju(DirectedGraph<KosarajuVertex> graph) {
        DepthFirstOrder dfs = new DepthFirstOrder(graph.transpose());

        markedVertices = new boolean[graph.getVertices().size()];
        sccIds = new int[graph.getVertices().size()];

        dfs.getDFSStack().stream().filter(v -> ! markedVertices[v.getId()]).forEach(v -> {
            dfs(v);
            count++;
        });
    }

    private void dfs(KosarajuVertex vertex) {
        markedVertices[vertex.getId()] = true;
        sccIds[vertex.getId()] = count;
        vertex.setComponentId(count);

        vertex.getNeighbours().stream().filter(v -> ! markedVertices[v.getId()]).forEach(this::dfs);
    }
}
