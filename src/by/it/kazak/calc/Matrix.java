package by.it.kazak.calc;

import java.util.Arrays;


public class Matrix extends Var{

    private double[][] value;
    public double[][] getValue() {return value;}

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
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
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] + valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix
                && value.length==((Matrix) other).value.length
                && value[0].length==((Matrix) other).value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] - valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix
                && value.length==((Matrix) other).value.length
                && value[0].length==((Matrix) other).value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] * valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Vector
                && value[0].length==((Vector) other).getValue().length) {
            double[] valueVector = ((Vector) other).getValue();
            double result[] = new double[valueVector.length];
            for (int i = 0; i < value.length; i++) {
                for(int j =0; j<valueVector.length; j++) {
                    result[i] = result[i] + value[i][j] * valueVector[j];
                }
            }
            return new Vector(result);

        }
        if(other instanceof Matrix
                && value[0].length==((Matrix) other).value.length) {
            double[][] result = new double[value[0].length][((Matrix) other).value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] = result[i][j] + value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar && ((Scalar) other).getValue()!=0) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] / valueScalar;
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
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

