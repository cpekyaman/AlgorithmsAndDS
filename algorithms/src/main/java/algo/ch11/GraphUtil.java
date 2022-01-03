package algo.ch11;

public final class GraphUtil {

    public static Graph testGraph() {
        Graph graph = new Graph(13);

        graph.addEdge(0, 1)
             .addEdge(0, 2)
             .addEdge(0, 6);

        graph.addEdge(6, 4);

        graph.addEdge(4, 5)
             .addEdge(4, 3);

        graph.addEdge(5, 3)
             .addEdge(5, 0);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10)
             .addEdge(9, 11)
             .addEdge(9, 12);

        graph.addEdge(11, 12);

        return graph;
    }

    private GraphUtil() {}
}
