package udemy.algo.advanced.tsp;

import java.util.ArrayList;
import java.util.List;

public class CityRegistry {
    private final List<City> cities;

    public CityRegistry() {
        this.cities = new ArrayList<>();
    }

    public void generate(int size) {
        for (int i = 0; i < size; i++) {
            this.add(new City(randomCoord(), randomCoord()));
        }
    }

    private int randomCoord() {
        return (int) (Math.random() * 100);
    }

    public void add(City city) {
        this.cities.add(city);
    }

    public int size() {
        return cities.size();
    }

    public City get(int i) {
        return this.cities.get(i);
    }
}
