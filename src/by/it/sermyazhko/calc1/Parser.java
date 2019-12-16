package by.it.sermyazhko.calc1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser{

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
       if(right == null)
            throw new CalcException(ResMan.INSTANCE.get(Messages.PARSER_CALCEXCEPTOPTION) + strRight);



        if (operation.equals("=")) {
            Var.set(strLeft, right);
            return right;
        }

        Var left =  Var.createVar(strLeft);
        if(left == null  && (!operation.equals("=")))
            throw new CalcException(ResMan.INSTANCE.get(Messages.PARSER_CALCEXCEPTOPTION) + strLeft);

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
        throw new CalcException(ResMan.INSTANCE.get(Messages.PARSER_CALCEXCEPTOPTIONGET));
    }

    Var calc(String expression) throws CalcException {
        String[] part = expression.split(PatternForExpression.OPERATION);
        if (part.length == 1) {
            return Var.createVar(expression);
        }
        List<String> operands = new ArrayList<String>(Arrays.asList(part));
        List<String> operators = new ArrayList<>();
        Matcher matcher = Pattern.compile(PatternForExpression.OPERATION).matcher(expression);
        while (matcher.find()){
            operators.add(matcher.group());
        }

        while (operators.size()>0){
            int index = getIndex(operators);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String op = operators.remove(index);
            Var result = oneOperation(left, op, right);
            operands.add(index,result.toString());
        }
        return Var.createVar(operands.get(0));
    }
}
