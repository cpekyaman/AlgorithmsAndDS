package algo.ch03;

import java.util.Set;

public final class DoubleStackInfixParser {
    private static final Set<String> operators = Set.of("+", "-", "*", "/");

    private final LinkedListStack<String> operatorStack;
    private final LinkedListStack<Double> operandStack;

    public DoubleStackInfixParser() {
        this.operandStack = new LinkedListStack<>();
        this.operatorStack = new LinkedListStack<>();
    }

    public Double parse(String expression) {
        String[] tokens = expression.split("[\\s]+");
        for(String token : tokens) {
            if(operators.contains(token)) {
                operatorStack.push(token);
            } else if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Double.parseDouble(token));
            } else if(token.equals(")")) {
                String operator = operatorStack.pop();
                if(operator == null) {
                    throw new IllegalArgumentException("invalid expression");
                }
                Double right = operandStack.pop();
                Double left = operandStack.pop();
                operandStack.push(apply(operator, left, right));
            }
        }
        return operandStack.pop();
    }

    private Double apply(String operator, Double left, Double right) {
        switch(operator) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }
        throw new IllegalArgumentException("unknown operator");
    }
}
