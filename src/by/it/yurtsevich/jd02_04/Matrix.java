package by.it.yurtsevich.jd02_04;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        double[][] resultMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, resultMatrix[i], 0, value[0].length);
        }
        this.value = resultMatrix;
    }

    Matrix(Matrix matrix) {
        double[][] resultMatrix = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, resultMatrix[i], 0, matrix.value[0].length);
        }
        this.value = resultMatrix;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]", " ");
        strMatrix = strMatrix.replaceAll("[}]", " ");
        strMatrix = strMatrix.trim();
        String[] stringMatrixRows = strMatrix.split(" , ");
        String[] rows = stringMatrixRows[0].split(",");
        int columnNumber = rows.length;
        double[][] resultMatrix = new double[stringMatrixRows.length][columnNumber];
        for (int i = 0; i < stringMatrixRows.length; i++) {
            String[] rowArray = stringMatrixRows[i].split(",");
            for (int j = 0; j < columnNumber; j++) {
                resultMatrix[i][j] = Double.parseDouble(rowArray[j]);
            }
        }
        this.value = resultMatrix;
    }

    @Override
    public Var add(Var var) {
        if (var instanceof Scalar) {
            double[][] resultMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    double scalarValue = ((Scalar) var).getValue();
                    resultMatrix[i][j] = resultMatrix[i][j] + scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        } else if (var instanceof Matrix) {
            if (this.value.length == ((Matrix) var).value.length && this.value[0].length == ((Matrix) var).value[0].length) {
                double[][] resultMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        double matrixValue = ((Matrix) var).value[i][j];
                        resultMatrix[i][j] = resultMatrix[i][j] + matrixValue;
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof Scalar) {
            double[][] resultMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    double scalarValue = ((Scalar) var).getValue();
                    resultMatrix[i][j] = resultMatrix[i][j] - scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        } else if (var instanceof Matrix) {
            if (this.value.length == ((Matrix) var).value.length && this.value[0].length == ((Matrix) var).value[0].length) {
                double[][] resultMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        double matrixValue = ((Matrix) var).value[i][j];
                        resultMatrix[i][j] = resultMatrix[i][j] - matrixValue;
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof Scalar) {
            double[][] resultMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    double scalarValue = ((Scalar) var).getValue();
                    resultMatrix[i][j] = resultMatrix[i][j] * scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        } else if (var instanceof Vector) {
            if (this.value[0].length == ((Vector) var).getValue().length) {
                double[] resultMatrix = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        double vectorValue = ((Vector) var).getValue()[j];
                        resultMatrix[i] = resultMatrix[i] + this.value[i][j] * vectorValue;
                    }
                }
                return new Vector(resultMatrix);
            }
        } else if (var instanceof Matrix) {
            if (this.value[0].length == ((Matrix) var).value.length) {
                double[][] resultMatrix = new double[this.value.length][((Matrix) var).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) var).value[0].length; j++) {
                        for (int k = 0; k < this.value[0].length; k++) {
                            resultMatrix[i][j] = resultMatrix[i][j] + this.value[i][k] * ((Matrix) var).value[k][j];
                        }
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        double scalarValue = ((Scalar) var).getValue();
        if (var instanceof Scalar && scalarValue != 0) {
            double[][] resultMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, resultMatrix[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    resultMatrix[i][j] = resultMatrix[i][j] / scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.div(var);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                stringBuilder.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                stringBuilder.append("}, {");
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}