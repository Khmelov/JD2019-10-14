package by.it.zabauniuk.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException{
        if (expression.equals("printvar")){
            printVariables();
            return null;
        }
        if (expression.equals("sortvar")){
            printSorted();
            return null;
        }

        String[] operand = expression.split(Patterns.OPERATION);
        Var right = Var.createVar(operand[1]);
        if(expression.contains("=")){
            return Var.saveVar(operand[0], right);
        }
//        else throw new CalcException("ERROR: ошибка ввода");
        Var left = Var.createVar(operand[0]);
        if (left == null || right == null) return null;
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
                default:
                    return null;
            }
        }
        return null;
    }

    private void printVariables(){
        Printer printer = new Printer();
        printer.printMap(Var.getVars());
    }

    private void printSorted(){
        Printer printer = new Printer();
        printer.printSorted(Var.getVars());
    }
}