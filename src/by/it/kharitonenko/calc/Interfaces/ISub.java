package by.it.kharitonenko.calc.Interfaces;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Vars.Var;

public interface ISub {
    Var sub(Var other) throws CalcException;
}
