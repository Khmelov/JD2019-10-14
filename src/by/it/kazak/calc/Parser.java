package by.it.kazak.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var evaluate(String expression) throws CalcException {
        String[] part = expression.split(Patterns.OPERATION, 2);
        if (part.length == 1) {
            return Var.createVar(expression);
        }
        Var right = Var.createVar(part[1]);
        if (expression.contains("=")) {
            Var.set(part[0], right);
            return right;
        }

        Var left = Var.createVar(part[0]);
        if (left != null && right != null) {
            Matcher matcher = Pattern
                    .compile(Patterns.OPERATION)
                    .matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
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

        }
        throw new CalcException("ERRRRRRRRRRRRRROR!");
    }
}
