package by.it.komarov.jd02_06;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation{

    private static Map<String, Var> vars = new HashMap<>();

    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)){ return new Scalar(operand); }
        if (operand.matches(Patterns.VECTOR)){ return new Vector(operand); }
        if (operand.matches(Patterns.MATRIX)){ return new Matrix(operand); }
        return null;
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw  new CalcException((String.format("Сложение %s + %s невозможно",this,other)));
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw  new CalcException((String.format("Вычитание %s - %s невозможно",this,other)));
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw  new CalcException((String.format("Умножение %s * %s невозможно",this,other)));
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw  new CalcException((String.format("Деление %s / %s невозможно",this,other)));
    }

    @Override
    public String toString(){
        return "Absract Class";
    }
}
