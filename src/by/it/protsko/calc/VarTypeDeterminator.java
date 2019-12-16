package by.it.protsko.calc;

public class VarTypeDeterminator {
    private static int varType;

    static int getTypeVar(String strVar) {
        varType = 0;
        if (strVar.matches(Patterns.SCALAR)) {
            return varType = 1;

        }
        if (strVar.matches(Patterns.VECTOR)) {
            return varType = 2;
        }
        if (strVar.matches(Patterns.MATRIX)) {
            return varType = 3;
        }
        return varType;
    }
}

