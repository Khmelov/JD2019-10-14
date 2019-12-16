package by.it.yurtsevich.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> prioririties = new HashMap<>();

    static {
        prioririties.put("*", 2);
        prioririties.put("/", 2);
        prioririties.put("+", 1);
        prioririties.put("-", 1);
        prioririties.put("=", 0);
    }

    Var calculate(String expression) throws CalcException {
        while (expression.contains("(")) {
            expression = simplifyExpression(expression);
        }

        expression = expression.trim().replace(" ", "");
        List<String> operands = new LinkedList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = operationPattern.matcher(expression);
        while (matcherOperation.find())
            operations.add(matcherOperation.group());

        while (operations.size() > 0) {
            int index = getPriorityIndex(operations);
            String operation = operations.remove(index);
            String right = operands.remove(index + 1);
            String left = operands.remove(index);
            Var tempResult = calculate(left, right, operation);
            operands.add(index, tempResult.toString());
        }

        return Var.createVar(operands.get(0));
    }

    private String simplifyExpression(String expression) throws CalcException {
        Pattern inBracketsPattern = Pattern.compile(Patterns.BRACKETS);
        Matcher bracketsMatcher = inBracketsPattern.matcher(expression);
        if (bracketsMatcher.find()) {
            int start = bracketsMatcher.start();
            int end = bracketsMatcher.end();
            String inBrackets = bracketsMatcher.group();
            inBrackets = inBrackets.replace("(", "").replace(")", "");
            Var result = calculate(inBrackets);
            expression = expression.replace(expression.substring(start, end), result.toString());
        }
        return expression;
    }

    private int getPriorityIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            int tmpPriority = prioririties.get(operations.get(i));
            if (tmpPriority > priority) {
                priority = tmpPriority;
                index = i;
            }
        }
        return index;
    }

    private Var calculate(String left, String right, String operation) throws CalcException {
        Var two = Var.createVar(right);
        if (operation.equals("="))
            return Var.saveVar(left, two);
        Var one = Var.createVar(left);
        if (one == null || two == null)
            throw new NullPointerException();
        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        throw new NullPointerException();
    }
}
