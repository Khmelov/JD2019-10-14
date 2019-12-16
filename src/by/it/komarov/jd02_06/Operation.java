package by.it.komarov.jd02_06;

interface Operation{
Var add(Var other) throws CalcException;
Var sub(Var other) throws CalcException;
Var mul(Var other) throws CalcException;
Var div(Var other) throws CalcException;
}