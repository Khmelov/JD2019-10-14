package by.it.konovalova.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException{
        String[] operand = expression.split(Patterns.OPERATION, 2);
        Var two = Var.createVar(operand[1]);
        if(expression.contains("=")){
            return Var.saveVar(operand[0], two);
        }
//if(expression.equals("printvar")){
//    return Scalar.createVar(operand[0]);
//}

        Var one = Var.createVar(operand[0]);
        if (one != null || two != null) {
            Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);

            if (matcher.find()) {
                String operation = matcher.group();
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
            }
        }
        return null;
    }
}
