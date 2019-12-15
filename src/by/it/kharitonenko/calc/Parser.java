package by.it.kharitonenko.calc;

import by.it.kharitonenko.calc.Interfaces.IPatterns;
import by.it.kharitonenko.calc.Vars.Var;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };


    private int getIndex(List<String> operators) {
        int index = -1;
        int prior = -1;
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if (priority.get(op) > prior) {
                prior = priority.get(op);
                index = i;
            }
        }
        return index;
    }

    private String createSubExpression(String expression) throws CalcException {
        while (expression.contains("(")) {
            Pattern brackets = Pattern.compile(IPatterns.BRACKETS);
            Matcher matcher = brackets.matcher(expression);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String expressionInBrackets = matcher.group();
                expressionInBrackets = expressionInBrackets.replace("(", "").replace(")", "");
                Var result = evaluate(expressionInBrackets);
                expression = expression.replace(expression.substring(start, end), result.toString());
            }
        }
        return expression;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = FactoryVar.createVar(strRight);
        //A=3 refactoring it
        if (operation.equals("=")) {
            Var.setVars(strLeft, right);
            return right;
        }

        Var left = FactoryVar.createVar(strLeft);
        if (left != null && right != null) {
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }

        }
        throw new CalcException(ConsoleRunner.lang.get(errorMessages.UNKNOWN));
    }


    public Var evaluate(String expression) throws CalcException {
        while (expression.contains("(")) {
            Pattern brackets = Pattern.compile(IPatterns.BRACKETS);
            Matcher matcher = brackets.matcher(expression);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String expressionInBrackets = matcher.group();
                expressionInBrackets = expressionInBrackets.replace("(", "").replace(")", "");
                Var result = evaluate(expressionInBrackets);
                expression = expression.replace(expression.substring(start, end), result.toString());
            }
        }
        String[] part = expression.split(IPatterns.OPERATION);
        if (part.length == 1) {
            return FactoryVar.createVar(expression);
        }
        List<String> operands = new ArrayList<>(Arrays.asList(part));
        List<String> operators = new ArrayList<>();
        Matcher matcher = Pattern.compile(IPatterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operators.add(matcher.group());
        }
        while (operators.size() > 0) {
            int index = getIndex(operators);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String op = operators.remove(index);
            Var result = oneOperation(left, op, right);
            operands.add(index, result.toString());
        }
        return FactoryVar.createVar(operands.get(0));
    }
}
