package by.it.kharitonenko.calc;

import by.it.kharitonenko.calc.Interfaces.IPatterns;
import by.it.kharitonenko.calc.Vars.Var;
import by.it.kharitonenko.calc.Vars.VarM;
import by.it.kharitonenko.calc.Vars.VarS;
import by.it.kharitonenko.calc.Vars.VarV;

public class FactoryVar {
    public static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(IPatterns.SCALAR))
            return new VarS(strVar);

        else if (strVar.matches(IPatterns.VECTOR))
            return new VarV(strVar);

        else if (strVar.matches(IPatterns.MATRIX))
            return new VarM(strVar);

        else if (Var.getVars().containsKey(strVar))
            return Var.getVars().get(strVar);
        else
            throw new CalcException(ConsoleRunner.lang.get(errorMessages.INIT));
    }
}
