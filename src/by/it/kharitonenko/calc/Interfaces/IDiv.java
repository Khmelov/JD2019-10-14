package by.it.kharitonenko.calc.Interfaces;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Vars.Var;

public interface IDiv {
    Var div(Var other) throws CalcException;
}
