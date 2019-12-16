package by.it.komarov.jd02_06;

public class Matrix extends Var {
    private double[][] matrix;

    Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    Matrix(Matrix matrix) {
        this.matrix = matrix.matrix;
    }

    Matrix(String strMatrix) throws CalcException{
        String[] array = strMatrix.split("(},)");
        matrix = new double[array.length][];
        for (int i = 0; i < matrix.length; i++) {
            String[] temp = (array[i].replaceAll("[{}]", "")).split("[,]");
            matrix[i] = new double[temp.length];
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Double.parseDouble(temp[j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i][j] = matrix[i][j] + valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix
                && matrix.length==((Matrix) other).matrix.length
                && matrix[0].length==((Matrix) other).matrix[0].length) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i][j] = matrix[i][j] + ((Matrix) other).matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
            if (other instanceof Scalar) {
                double valueScalar = ((Scalar) other).getValue();
                double[][] result = new double[matrix.length][matrix[0].length];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        result[i][j] = matrix[i][j] - valueScalar;
                    }
                }
                return new Matrix(result);
            }
            if(other instanceof Matrix
                    && matrix.length==((Matrix) other).matrix.length
                    && matrix[0].length==((Matrix) other).matrix[0].length) {
                double[][] result = new double[matrix.length][matrix[0].length];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        result[i][j] = matrix[i][j] - ((Matrix) other).matrix[i][j];
                    }
                }
                return new Matrix(result);
            }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i][j] = matrix[i][j] * valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Vector
                && matrix[0].length==((Vector) other).getValue().length) {
            double[] valueVector = ((Vector) other).getValue();
            double result[] = new double[valueVector.length];
            for (int i = 0; i < matrix.length; i++) {
                for(int j =0; j<valueVector.length; j++) {
                    result[i] = result[i] + matrix[i][j] * valueVector[j];
                }
            }
            return new Vector(result);

        }
        if(other instanceof Matrix
                && matrix[0].length==((Matrix) other).matrix.length) {
            double[][] result = new double[matrix[0].length][((Matrix) other).matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < ((Matrix) other).matrix[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).matrix.length; k++) {
                        result[i][j] = result[i][j] + matrix[i][k]*((Matrix) other).matrix[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i][j] = matrix[i][j] / valueScalar;
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";

        for (int i = 0; i < matrix.length; i++) {
            if(i == 1)
            sb.append(", ");
            sb.append("{");

            for (int j = 0; j < matrix.length; j++) {
                sb.append(delimiter).append(matrix[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            delimiter = "";
        }
        sb.append("}");
        return sb.toString();
    }

}
