package by.it.komarov.jd02_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private Map<String,Integer> priority=new HashMap<String,Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };


    private int getIndex(List<String> operators) {
        int index=-1;
        int prior=-1;
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if (priority.get(op)>prior){
                prior=priority.get(op);
                index=i;
            }
        }
        return index;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        //A=3 refactoring it
        if (operation.equals("=")) {
            Var.set(strLeft, right);
            return right;
        }

        throw new CalcException("Что то странное происходит!!!!");
    }

    Var calc(String expression) throws CalcException{
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);

        if (operand[0] == null || operand[1] == null){
            return null;
        }

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
                default:
                    System.out.println("Нет такой операции");
            }
        }
        return null;
    }

    Var evaluate(String expression) throws CalcException {
        String[] part = expression.split(Patterns.OPERATION);
        if (part.length == 1) {
            return Var.createVar(expression);
        }
        List<String> operands=new ArrayList<String>(Arrays.asList(part));
        List<String> operators=new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()){
            operators.add(matcher.group());
        }

        while (operators.size()>0){
            int index=getIndex(operators);
            String left=operands.remove(index);
            String rigth=operands.remove(index);
            String op=operators.remove(index);
            Var result = oneOperation(left, op, rigth);
            operands.add(index,result.toString());
        }
        return Var.createVar(operands.get(0));
    }
}
