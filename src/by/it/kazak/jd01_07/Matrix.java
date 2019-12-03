package by.it.kazak.jd01_07;
import java.util.Arrays;



public class Matrix extends Var{

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }
    Matrix(String strMatrix){
        StringBuilder sb;
        sb = new StringBuilder(strMatrix.replaceAll("[{} ]", ""));
        String[] str = sb.toString().split("[^\\d.]+");
        double[] o = new double[str.length];
        double[][] matrix = new double[2][o.length/2];
        for (int i = 0; i < str.length; i++) {
            o[i] = Double.parseDouble(str[i]);
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = o[count++];
            }
        }
        this.value=matrix;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String d = "";
        for (double[] element : value) {
            sb.append(d).append("{").append(Arrays.toString(element).replace('[', ' ').replace(']', ' ').trim()).append("}");
            d = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

