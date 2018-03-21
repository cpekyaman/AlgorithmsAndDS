package udemy.algo.advanced.tpordering;

import org.junit.Before;
import org.junit.Test;
import udemy.algo.advanced.graph.GraphVertex;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopologicalOrderingTest  {
    private TopologicalOrdering<Integer> tp;
    private List<GraphVertex<Integer>> vertices;

    @Before
    public void setup() {
        tp = new TopologicalOrdering<>();

        vertices = IntStream.rangeClosed(0, 5).boxed().map(GraphVertex::new).collect(Collectors.toList());
        System.out.println(vertices);

        vertices.get(2).addNeighbour(vertices.get(3));

        vertices.get(3).addNeighbour(vertices.get(1));

        vertices.get(4).addNeighbour(vertices.get(0));
        vertices.get(4).addNeighbour(vertices.get(1));

        vertices.get(5).addNeighbour(vertices.get(0));
        vertices.get(5).addNeighbour(vertices.get(2));
    }

    @Test
    public void testOrder() {
        // when
        vertices.stream().filter(v -> ! v.isVisited()).forEach(tp::order);

        // then
        //tp.getVertices().forEach(v -> System.out.printf("%s ", v.getData()));
        Stack<GraphVertex<Integer>> vertexStack = tp.getVertices();
        while(! vertexStack.isEmpty()) {
            System.out.printf("%s ", vertexStack.pop().getData());
        }
    }
}
