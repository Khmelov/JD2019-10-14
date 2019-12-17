package by.it.zimina.jd02_06.calc_factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private final HashMap<String, Integer> priorityTable = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("*", 2);
            this.put("/", 2);
            this.put("-", 1);
        }
    };

    private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priority < priorityTable.get(operation)) {
                index = i;
                priority = priorityTable.get(operation);
            }
        }
        return index;
    }


    private Var calcOneOperation(String left, String operation, String right) throws CalcException {
        if (operation.contains("=")) {
            Var two = Var.createVar(right);
            Var.saveVar(left, two);
            return two;
        }

        Var one = Var.createVar(left);
        Var two = Var.createVar(right);

        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "/":
                return one.div(two);
            case "*":
                return one.mul(two);
        }

        throw new CalcException("unknown action: " + operation);
    }

    Var calc(String expression) throws CalcException {

        expression = expression.replace(" ", "");
        String[] part = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(part));
        List<String> operations = new ArrayList<>();
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOperation.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (!operations.isEmpty()) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var tmp = calcOneOperation(left, operation, right);
            operands.add(index, tmp.toString());
        }
        return Var.createVar(operands.get(0).replace(" ", ""));
    }
}