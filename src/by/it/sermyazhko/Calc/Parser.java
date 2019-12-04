package by.it.sermyazhko.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser{
    Var calc(String expression) throws CalcException {
        String[] exp = expression.split(PatternForExpression.OPERATION, 2);

        if (exp.length == 1){
            return Var.createVar(expression);
        }

        Var right = Var.createVar(exp[1]);

        if(expression.contains("=")){
            Var.set(exp[0],right);
            return right;
        }

        Var left = Var.createVar(exp[0]);
        if (left != null && right != null){
            Matcher matcher = Pattern
                    .compile(PatternForExpression.OPERATION)
                    .matcher(expression);
            if (matcher.find()){
                String result = matcher.group();
                switch (result){
                    case "+": return left.add(right);
                    case "-": return left.sub(right);
                    case "*": return left.mul(right);
                    case "/": return left.div(right);
                }
            }

        }
        return null;
    }
}
