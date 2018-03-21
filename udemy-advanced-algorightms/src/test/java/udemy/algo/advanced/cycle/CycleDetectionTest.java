package udemy.algo.advanced.cycle;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CycleDetectionTest {
    private CycleDetection cycleDetection;
    private List<CycleVertex<Integer>> vertices;

    @Before
    public void setup() {
        vertices = IntStream.rangeClosed(1, 6).boxed().map(CycleVertex::new).collect(Collectors.toList());
        System.out.println(vertices);

        vertices.get(0).addNeighbour(vertices.get(1));
        vertices.get(0).addNeighbour(vertices.get(2));

        vertices.get(1).addNeighbour(vertices.get(2));

        vertices.get(3).addNeighbour(vertices.get(0));
        vertices.get(3).addNeighbour(vertices.get(4));

        vertices.get(4).addNeighbour(vertices.get(5));
        vertices.get(5).addNeighbour(vertices.get(3));

        cycleDetection = new CycleDetection<>();
    }

    @Test
    public void testCycle() {
        // when / then
        cycleDetection.detect(vertices);
    }
}
