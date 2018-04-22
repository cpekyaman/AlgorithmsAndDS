package udemy.algo.advanced.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tour {
    private final List<City> cities;
    private double distance = 0.0D;

    public Tour(CityRegistry registry) {
        this.cities = new ArrayList<>();
        for (int i = 0; i < registry.size(); i++) {
            this.cities.add(null);
        }
    }

    public Tour(List<City> tour) {
        this.cities = new ArrayList<>();
        this.cities.addAll(tour);
    }

    public void generate(CityRegistry registry) {
        for (int i = 0; i < registry.size(); i++) {
            this.cities.set(i, registry.get(i));
        }
        Collections.shuffle(this.cities);
        this.distance = 0.0D;
    }

    public int size() {
        return cities.size();
    }

    public String toString() {
        return this.cities.toString();
    }

    public double getDistance() {
        if(distance == 0.0) {
            distance = calculateDistance();
        }
        return distance;
    }

    private double calculateDistance() {
        double totalDistance = 0.0D;
        for (int i = 0; i < this.size(); i++) {
            City from = cities.get(i);
            City to;
            if(i + 1 < this.size()) {
                to = cities.get(i + 1);
            } else {
                to = cities.get(0);
            }

            totalDistance += from.distance(to);
        }
        return totalDistance;
    }

    public void randomSwap() {
        Random rand = new Random(System.currentTimeMillis());

        int index1 = rand.nextInt(this.size());
        City city1 = this.cities.get(index1);

        int index2 = rand.nextInt(this.size());
        City city2 = this.cities.get(index2);

        this.cities.set(index1, city2);
        this.cities.set(index2, city1);

        this.distance = 0.0D;
    }

    public List<City> getCities() {
        return cities;
    }
}
