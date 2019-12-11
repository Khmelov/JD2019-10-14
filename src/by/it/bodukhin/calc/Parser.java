package by.it.bodukhin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private Map<String, Integer> priority = new HashMap<String,Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

    private int getIndex(List<String> operators) {
        int index = -1;
        int prior = -1;
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if(priority.get(op)>prior) {
                prior = priority.get(op);
                index = i;
            }
        }
        return index;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if(operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }
        Var left = Var.createVar(strLeft);
        if(left != null && right !=null) {
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
        throw new CalcException("Что-то невероятное происходит");
    }

    Var evaluate(String expression) throws CalcException {
        while (expression.contains("(") | expression.contains(")")){
            expression=evaluateBrackets(expression);
        }
        String[] part = expression.split(Patterns.OPERATION);
        if(part.length == 1){
            return Var.createVar(expression);
        }
        List<String> operands = new ArrayList<>(Arrays.asList(part));
        List<String> operators = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()){
            operators.add(matcher.group());
        }
        while (operators.size() > 0){
            int index = getIndex(operators);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String op = operators.remove(index);
            Var result = oneOperation(left, op, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    String evaluateBrackets(String expression) throws CalcException {
        expression=expression.replaceAll(" ","");
        int firstBracket = expression.lastIndexOf("(");
        int lastBracket = expression.indexOf(")");
        String evalBracket = expression.substring(firstBracket + 1, lastBracket);
        String resultInBracket = String.valueOf(evaluate(evalBracket));
        expression = expression.replace(expression.substring(firstBracket, lastBracket + 1), resultInBracket);
        return expression;
    }
}
