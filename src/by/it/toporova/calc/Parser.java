package by.it.toporova.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String exrpession) throws CalcException {
        String[] operand = exrpession.split(Patterns.OPERATION);
        Var second = Var.createVar(operand[1]);
//создана вторая переменная для выражений типа ключ=значение
        //вызов метода saveVar, где 0 операнд - ключ
        if (exrpession.contains("=")) {
            return Var.saveVar(operand[0], second);
        }
        Var first = Var.createVar(operand[0]); //передаем в var для преобразоования
        if (first == null || second == null)
            return null; //TODO create error

        Pattern p = Pattern.compile(Patterns.OPERATION); //задание шаблона
        Matcher matcher = p.matcher(exrpession); //сравнение шаблона с выражением
        if (matcher.find()) {//если матчет нашел ч-либо, то
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return first.add(second);
                case "-":
                    return first.sub(second);
                case "*":
                    return first.mul(second);
                case "/":
                    return first.div(second);


            }
        }
        throw new CalcException("Что-то странное происходит");
    }
}
