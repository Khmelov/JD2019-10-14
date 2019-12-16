package by.it.toporova.calculator_jd02_05_and_jd02_06;

import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Errors;

class VarFabric {

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (Var.vars.containsKey(operand))
           return Var.vars.get(operand);
        throw new CalcException(ResMan.INSTANCE.get(Errors.VARIABLE) + " " + operand + " "
                + ResMan.INSTANCE.get(Errors.NOT_DEFINED));
    }

}
