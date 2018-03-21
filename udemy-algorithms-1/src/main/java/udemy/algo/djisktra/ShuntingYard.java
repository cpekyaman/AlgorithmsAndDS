package udemy.algo.djisktra;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by raistlin on 9/24/2017.
 */
public class ShuntingYard {
    private final Stack<String> operators;
    private final Stack<Double> values;

    private final Map<String, BiFunction<Double,Double,Double>> operations;

    public ShuntingYard() {
        this.operators = new Stack<>();
        this.values = new Stack<>();

        this.operations = new HashMap<>();
        this.operations.put("+", (a,b) -> a + b);
        this.operations.put("-", (a,b) -> a - b);
        this.operations.put("*", (a,b) -> a * b);
        this.operations.put("/", (a,b) -> a / b);
    }

    public void parse(String expression) {
        String[] tokens = expression.split(" ");

        for(String token : tokens) {
            if(this.operations.containsKey(token)) {
                this.operators.push(token);
            } else if(")".equals(token)) {
                this.values.push(calculate());
            } else if(isNumeric(token)) {
                this.values.push(Double.parseDouble(token));
            }
        }

        System.out.println(this.values.pop());
    }

    private Double calculate() {
        // last in first out, first pop is second operand
        Double b = this.values.pop();
        Double a = this.values.pop();

        return this.operations.get(this.operators.pop()).apply(a, b);
    }

    private boolean isNumeric(String token) {
        return token.chars().allMatch(Character::isDigit);
    }

    public static void main(String[] args) {
        ShuntingYard sh = new ShuntingYard();
        sh.parse("( ( 1 + 2 ) * ( 4 / 2 ) )");
        sh.parse("( ( 5 - 2 ) * ( 4 / 2 ) )");
        sh.parse("( ( 1 - 3 ) * ( 2 * 3 ) )");
    }
}
