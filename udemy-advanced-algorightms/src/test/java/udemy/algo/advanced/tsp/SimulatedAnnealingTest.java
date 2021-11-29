package udemy.algo.advanced.tsp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimulatedAnnealingTest {
    private SimulatedAnnealing tsp;

    @BeforeEach
    public void setup() {
        CityRegistry registry = new CityRegistry();
        registry.generate(500);

        this.tsp = new SimulatedAnnealing(registry);
    }

    @Test
    public void testSimulate() {
        tsp.simulate();
        System.out.printf("End Solution distance is %.2f\n", this.tsp.getBest().getDistance());
    }
}
