package by.it.zimina.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;
    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }
    Matrix(double[][] value) {
        this.value = Arrays.copyOf(Arrays.copyOf(value, value[0].length), value.length);
    }

    Matrix(String  strMatrix) {
        String[] arr = strMatrix.replaceAll("[{ }]","").split(",");
        value = new double[2][2];
        for (int i = 0; i < value.length; i++) {
            value[0][i] = Double.parseDouble(arr[i]);
        }
        int j = 0;
        for (int i = 2; i < arr.length; i++) {
            value[1][j] = Double.parseDouble(arr[i]);
            j++;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] row : value) {
            String delimiter2 = "";
            sb.append(delimiter);
            sb.append("{");
            for (double element : row) {
                sb.append(delimiter2).append(element);
                delimiter2 = ", ";
            }
            sb.append("}");
            delimiter = ", ";
        }


        sb.append("}");
        return sb.toString();
    }
}
