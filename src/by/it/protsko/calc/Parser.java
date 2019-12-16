package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.ParserMessages;
import by.it.protsko.calc.lang_operations.ResurceManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.protsko.calc.Var.vars;

class Parser {

    private Map<String, Integer> operationPriority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getIndexOperation(List<String> operators) {
        int operatorIndex = -1;
        int operatorPriority = -1;

        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            if (operationPriority.get(operator) > operatorPriority) {
                operatorPriority = operationPriority.get(operator);
                operatorIndex = i;
            }
        }
        return operatorIndex;
    }


    Var dataOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var rightOperandValue = Var.createVar(rightOperand);

        if (operation.equals("=")) {
            vars.put(leftOperand, rightOperandValue);
            return rightOperandValue;
        }
        Var leftOperandValue = Var.createVar(leftOperand);

        if (leftOperandValue != null && rightOperandValue != null) {
            switch (operation) {
                case "+":
                    return leftOperandValue.add(rightOperandValue);
                case "-":
                    return leftOperandValue.sub(rightOperandValue);
                case "*":
                    return leftOperandValue.mul(rightOperandValue);
                case "/":
                    return leftOperandValue.div(rightOperandValue);
            }
        }
        throw new CalcException(ResurceManager.INSTANSE.getMessage(ParserMessages.ERR_INCORR_EXPRESSION));
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll(" ", "");
        String[] membersOfExpression = expression.split(Patterns.OPERATIONS);
        if (membersOfExpression.length == 1) {
            return Var.createVar(expression);
        }
        List<String> expressionOperands = new ArrayList<>(Arrays.asList(membersOfExpression));
        List<String> expressionOperators = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATIONS).matcher(expression);
        while (matcher.find()) {
            expressionOperators.add(matcher.group());
        }

        while (expressionOperators.size() > 0) {
            int indexOperation = getIndexOperation(expressionOperators);
            String leftOperand = expressionOperands.remove(indexOperation);
            String rigthOperand = expressionOperands.remove(indexOperation);
            String operation = expressionOperators.remove(indexOperation);
            Var operationResult = dataOperation(leftOperand, operation, rigthOperand);
            expressionOperands.add(indexOperation, operationResult.toString());
        }
        return Var.createVar(expressionOperands.get(0));
    }
}
