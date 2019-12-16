package by.it.yurtsevich.jd02_05.calc;

import by.it.yurtsevich.jd02_05.Errors;

import by.it.yurtsevich.jd02_05.ResourceManager;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    public static ResourceManager resourceManager=ResourceManager.INSTANCE;
    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static void printVar() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException(resourceManager.get(Errors.CANT_CREATE_VAR)+strVar);
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(resourceManager.get(Errors.CANT_ADD));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Errors.CANT_SUB));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Errors.CANT_MUL));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resourceManager.get(Errors.CANT_DIV));
    }
}
