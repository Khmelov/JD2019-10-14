package by.it.zimina.jd02_06.calc_factory;

public class MatrixFactory implements VarFactory {
    @Override
    public Var createVar(String strVar) {

        String[] strArray = strVar.split("[\\}]+");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].replaceAll("[^-0-9\\.]+", " ");
            strArray[i] = strArray[i].trim();
        }

        String[][] strMatrix = new String[strArray.length][strArray.length];
        for (int i = 0; i < strMatrix.length; i++) {
            strMatrix[i] = strArray[i].split(" ");
        }

        double[][] result = new double[strMatrix.length][strMatrix[0].length];
        for (int i = 0; i < strMatrix.length; i++) {
            for (int j = 0; j < strMatrix[i].length; j++) {
                result[i][j] = Double.parseDouble(strMatrix[i][j]);
            }
        }
        return new Matrix(result);
    }
}