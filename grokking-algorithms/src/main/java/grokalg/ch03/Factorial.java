package grokalg.ch03;

public final class Factorial {
    public int calculate(int n) {
        if(n < 0) {
            throw new IllegalArgumentException();
        }
        return factorial(1, n);
    }

    private int factorial(int acc, int n) {
        if(n <= 1) {
            return acc;
        }

        return factorial(acc * n, n -1);
    }
}
