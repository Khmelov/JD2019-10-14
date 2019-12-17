package by.it.zimina.jd02_06.calc_factory;

public class VectorFactory implements VarFactory {
    @Override
    public Var createVar(String stringVar) {
        stringVar = stringVar.replaceAll("[^-0-9\\.]+", " ");
        stringVar = stringVar.trim();
        String[] strArray = stringVar.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return new Vector(result);
    }
}