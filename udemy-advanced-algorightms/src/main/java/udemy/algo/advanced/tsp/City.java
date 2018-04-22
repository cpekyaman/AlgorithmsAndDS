package udemy.algo.advanced.tsp;

public class City {
    private final int x;
    private final int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(City other) {
        return Math.sqrt(Math.pow(Math.abs(x - other.x), 2) + Math.pow(Math.abs(y - other.y), 2));
    }

    @Override
    public String toString() {
       return String.format("(%d, %d)", x, y);
    }
}
