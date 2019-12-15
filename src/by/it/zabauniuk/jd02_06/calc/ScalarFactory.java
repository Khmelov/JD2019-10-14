package by.it.zabauniuk.jd02_06.calc;

public class ScalarFactory implements VarFactory {
    @Override
    public Var createVar(String strVar) {
        Var result = new Scalar(Double.parseDouble(strVar));
        return result;
    }
}