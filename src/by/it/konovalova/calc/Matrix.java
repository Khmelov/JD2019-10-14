package by.it.konovalova.calc;

class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String[] rows = strMatrix.split("},");
        String[][] matrix = new String[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i].replaceAll("\\{", "").replaceAll("\\}", "").split(",");
        }
        double[][] arr = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = Double.parseDouble(matrix[i][j]);
            }
        }
        this.value = arr;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix &&
                value.length == ((Matrix) other).value.length &&
                value[0].length == ((Matrix) other).value[0].length) {

            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else
            this.value = Matrix.this.getValue();
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix &&
                value.length == ((Matrix) other).value.length &&
                value[0].length == ((Matrix) other).value[0].length) {

            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else
            this.value = Matrix.this.getValue();
        return super.add(other);
    }

    @Override
    public Var mul(Var other)throws CalcException {

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
        }

         else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[][] mul = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    mul[i][j] = value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}



