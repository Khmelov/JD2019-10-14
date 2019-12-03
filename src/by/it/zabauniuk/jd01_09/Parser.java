package by.it.zabauniuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String exrpession) {
        String [] operand = exrpession.split(Patterns.OPERATION);
        Var first = Var.createVar(operand[0]);
        Var second = Var.createVar(operand[1]);
        if (first==null || second==null)
            return null; //TODO create error

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = p.matcher (exrpession);
        if (matcher.find()){
            String operation=matcher.group();
            switch (operation){
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);
            }
        }
        return null;
    }
}
