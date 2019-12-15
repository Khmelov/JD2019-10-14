package by.it.zabauniuk.jd02_06.calc;

public class VectorFactory implements VarFactory {
    @Override
    public Var createVar(String strVar) {
        strVar = strVar.replaceAll("[^-0-9\\.]+", " ");
        strVar = strVar.trim();
        String[] strArray = strVar.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return new Vector(result);
    }
}