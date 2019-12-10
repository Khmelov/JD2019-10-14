package by.it.yurtsevich.calc11;

import java.util.Arrays;

public class Matrix extends Var {
    private double [][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i=0; i < value.length; i++)
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i=0; i < matrix.value.length; i++)
            this.value[i] = Arrays.copyOf(matrix.value[i], matrix.value[i].length);
    }

    Matrix(String strMatrix) {
        String s  = strMatrix.replaceAll("\\{", "");
        s = s.substring(0, s.length()-2);
        String s1[] = s.split("},");
        String my_matrix[][] = new String[s1.length][];
        for (int i = 0; i < s1.length; i++) {
            s1[i] = s1[i].trim();
            String single_double[] = s1[i].split(",");
            my_matrix[i] = new String[single_double.length];
            for (int j = 0; j < single_double.length; j++) {
                my_matrix[i][j] = single_double[j];
            }
        }
        value = new double [s1.length][];
        for (int i = 0; i<my_matrix.length; i++) {
            value[i] = new double[my_matrix[i].length];
            for (int j = 0; j < my_matrix[i].length; j++) {
                value[i][j] = Double.parseDouble(my_matrix[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for (int i=0; i<value.length; i++) {
            result.append("{");
            String delimiter = "";
            for (double x: value[i]) {
                result.append(delimiter).append(x);
                delimiter = ", ";
            }
            if (i == value.length - 1)
                delimiter = "";
            result.append("}").append(delimiter);
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double [][]res = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    res[i][j] = this.value[i][j] + ((Scalar) other).getValue();
            return new Matrix(res);
        }
        if (other instanceof Matrix) {
            double [][] result = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
            return new Matrix(result);
        }
        return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double [][]result = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    result[i][j] = this.value[i][j] - ((Scalar) other).getValue();
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double [][] res = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
            return new Matrix(res);
        }
        return null;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double [][]res = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    res[i][j] = this.value[i][j] * ((Scalar) other).getValue();
            return new Matrix(res);
        }
        if (other instanceof Vector) {
            double [] res = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j = 0; j< ((Vector) other).getValue().length; j++)
                    res[i] = res[i] + this.value[i][j] * ((Vector) other).getValue()[j];
            return new Vector(res);
        }
        if (other instanceof Matrix) {
            double[][] result = new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[i].length; j++)
                    for (int k = 0; k < ((Matrix)other).value.length; k++)
                        result[i][j] = result[i][j] + this.value[i][k] * ((Matrix)other).value[k][j];
            return new Matrix(result);
        }
        return null;
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double [][]res = new double [this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for(int j=0; j< this.value[i].length; j++)
                    res[i][j] = this.value[i][j] / ((Scalar) other).getValue();
            return new Matrix(res);
        }
        return null;
    }
}



