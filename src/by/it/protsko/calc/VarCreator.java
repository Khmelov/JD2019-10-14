package by.it.protsko.calc;

public class VarCreator {

   static Var createVar(VarTypes type, String stringVar) {
        Var varToCreate = null;
        switch (type) {
            case SCALAR:
                varToCreate = new Scalar(stringVar);
                break;
            case VECTOR:
                varToCreate = new Vector(stringVar);
                break;
            case MATRIX:
                varToCreate = new Matrix(stringVar);
                break;
        }
        return varToCreate;
    }
}
