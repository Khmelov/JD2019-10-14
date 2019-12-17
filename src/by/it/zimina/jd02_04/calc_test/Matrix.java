package by.it.zimina.jd02_04.calc_test;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(Arrays.copyOf(value, value[0].length), value.length);
    }

    public Matrix(String strMatrix) {
        String[] row = strMatrix.split("},");
        String[][] col = new String[row.length][];
        for (int i = 0; i < row.length; i++) {
            col[i] = row[i].replaceAll("\\{", "").replaceAll("\\}", "").split(",");
        }
        double[][] matrix = new double[col.length][col[0].length];
        for (int i = 0; i < col.length; i++) {
            for (int j = 0; j < col[i].length; j++) {
                matrix[i][j] = Double.parseDouble(col[i][j]);
            }
        }
        this.value = matrix;
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

    @Override
    public Var add(Var other) throws CalcException {
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
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
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
            double[][] mul = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    mul[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        }
        if (other instanceof Vector &&
                value.length == ((Vector) other).getValue().length) {

            double[] mulVector = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    mulVector[i] = mulVector[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mulVector);
        }

        if (other instanceof Matrix &&
                value.length == ((Matrix) other).value.length &&
                value[0].length == ((Matrix) other).value[0].length) {

            double[][] mul = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value[0].length; k++) {
                        mul[i][j] = mul[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        } else
            return super.mul(other);
    }
}
