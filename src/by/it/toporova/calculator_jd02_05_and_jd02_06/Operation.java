package by.it.toporova.calculator_jd02_05_and_jd02_06;

interface Operation {

    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}