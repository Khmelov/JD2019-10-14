package by.it.kharitonenko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Var get(String name) {
        return vars.get(name);
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " + " + other + " невозможно\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " - " + other + " невозможно\n");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " * " + other + " невозможно\n");    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " / " + other + " невозможно\n");    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else
            return null;
    }
}
