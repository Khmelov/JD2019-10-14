package by.it.zimina.jd02_06.calc_factory;

public class ScalarFactory implements VarFactory {
    @Override
    public Var createVar(String strVar) {
        Var result = new Scalar(Double.parseDouble(strVar));
        return result;
    }
}