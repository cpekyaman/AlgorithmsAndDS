package algo.graph;

import algo.ch13.Digraph;

public final class GraphUtil {

    public static <T extends BaseGraph> T testGraph(T graph) {
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

    public static <T extends BaseGraph> T weightedTestGraph(T graph) {
        graph.addEdge(0, 7, 16)
             .addEdge(0, 4, 38)
             .addEdge(0, 2, 26);


        graph.addEdge(1, 7, 19)
             .addEdge(1, 3, 29)
             .addEdge(1, 5, 32)
             .addEdge(1, 2, 36);

        graph.addEdge(2, 3, 17)
             .addEdge(2, 7, 34);

        graph.addEdge(3, 6, 52);

        graph.addEdge(4, 5, 35)
             .addEdge(4, 7, 37);

        graph.addEdge(5, 7, 28);

        graph.addEdge(6, 2, 40)
             .addEdge(6, 0, 58)
             .addEdge(6, 4, 93);

        return graph;
    }

    public static Digraph directedTestGraph() {
        Digraph graph = new Digraph();

        graph.addEdge(0, 1)
             .addEdge(0, 2)
             .addEdge(0, 5);

        graph.addEdge(1, 4);

        graph.addEdge(3, 6)
             .addEdge(3, 5)
             .addEdge(3, 4)
             .addEdge(3, 2);

        graph.addEdge(5, 2);

        graph.addEdge(6, 4)
             .addEdge(6, 0);

        return graph;
    }


    public static Digraph directedWeightedTestGraph() {
        Digraph graph = new Digraph();

        graph.addEdge(0, 2, 26)
             .addEdge(0, 4, 38);

        graph.addEdge(1, 3, 29);

        graph.addEdge(2, 7, 34);

        graph.addEdge(3, 6, 52);

        graph.addEdge(4, 5, 35)
             .addEdge(4, 7, 37);

        graph.addEdge(5, 4, 35)
             .addEdge(5, 1, 32)
             .addEdge(5, 7, 28);

        graph.addEdge(6, 2, 40)
             .addEdge(6, 0, 58)
             .addEdge(6, 4, 93);

        graph.addEdge(7, 5, 28)
             .addEdge(7, 3, 39);

        return graph;
    }

    private GraphUtil() {}
}
