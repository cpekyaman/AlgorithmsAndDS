package udemy.algo.advanced.tsp;

public class SimulatedAnnealing {
    private static final double START_TEMPERATURE = 10000.0;
    private static final double COOLDOWN_RATE = 0.003;

    private Tour best;
    private final CityRegistry registry;

    public SimulatedAnnealing(CityRegistry registry) {
        this.registry = registry;
    }

    public void simulate() {
        double temperature = START_TEMPERATURE;

        Tour currentSolution = new Tour(registry);
        currentSolution.generate(registry);

        System.out.printf("Initial distance: %.2f\n", currentSolution.getDistance());

        best = new Tour(currentSolution.getCities());

        while(temperature > 1) {
            Tour nextSolution = new Tour(currentSolution.getCities());
            nextSolution.randomSwap();

            double currentEnergy = currentSolution.getDistance();
            double nextEnergy = nextSolution.getDistance();

            if(acceptanceProbability(currentEnergy, nextEnergy, temperature) > Math.random()) {
                currentSolution = new Tour(nextSolution.getCities());
            }

            if(currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getCities());
            }

            temperature = temperature * (1 - COOLDOWN_RATE);
        }
    }

    public Tour getBest() {
        return best;
    }

    private double acceptanceProbability(double currentEnergy, double nextEnergy, double temperature) {
        if(nextEnergy < currentEnergy) {
            return 1.0;
        } else {
            return Math.exp((currentEnergy - nextEnergy) / temperature);
        }
    }
}
