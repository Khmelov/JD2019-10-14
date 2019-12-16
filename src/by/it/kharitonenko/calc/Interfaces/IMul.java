package by.it.kharitonenko.calc.Interfaces;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Vars.Var;

public interface IMul {
    Var mul(Var other) throws CalcException;
}
