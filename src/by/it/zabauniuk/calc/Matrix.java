package by.it.zabauniuk.calc;

class Matrix extends Var {

    private double[][] value;

    double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        this.value = stringToMatrix(strMatrix);
    }

    private double[][] stringToMatrix(String str) {

        String[] strArray = str.split("[\\}]+");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].replaceAll("[^0-9\\.]+", " ");
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
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String opening = "{";
        for (double[] doubles : value) {
            String delimiter = "";
            sb.append(opening);
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(doubles[j]);
                delimiter = ", ";
            }
            sb.append("}");
            opening = ", {";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] sum1 = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum1.length; i++) {
                for (int j = 0; j < sum1[0].length; j++) {
                    sum1[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(sum1);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).getValue().length
                    && this.value[0].length == ((Matrix) other).getValue()[0].length) {
                double[][] sum2 = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sum2.length; i++) {
                    for (int j = 0; j < sum2[0].length; j++) {
                        sum2[i][j] = this.value[i][j] + ((Matrix) other).getValue()[i][j];
                    }
                }
                return new Matrix(sum2);
            } else {
                throw new CalcException("матрицы разного размера");
            }
        } else {
            throw new CalcException("операция невозможна");
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] sub1 = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub1.length; i++) {
                for (int j = 0; j < sub1[0].length; j++) {
                    sub1[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub1);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).getValue().length
                    && this.value[0].length == ((Matrix) other).getValue()[0].length) {
                double[][] sub2 = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sub2.length; i++) {
                    for (int j = 0; j < sub2[0].length; j++) {
                        sub2[i][j] = this.value[i][j] - ((Matrix) other).getValue()[i][j];
                    }
                }
                return new Matrix(sub2);
            } else {
                throw new CalcException("матрицы разного размера");
            }
        } else {
            throw new CalcException("операция невозможна");
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] mul1 = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul1.length; i++) {
                for (int j = 0; j < mul1[0].length; j++) {
                    mul1[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul1);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] mul2 = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        mul2[i] = mul2[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(mul2);
            } else throw new CalcException("размеры вектора и матрицы не совпадают");
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).getValue().length
                    && this.value[0].length == ((Matrix) other).getValue()[0].length) {
                double[][] mul3 = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value.length; j++) {
                        for (int k = 0; k < ((Matrix) other).getValue().length; k++) {
                            mul3[i][j] = mul3[i][j] + this.value[i][k] * ((Matrix) other).getValue()[k][j];
                        }
                    }
                }
                return new Matrix(mul3);
            } else {
                throw new CalcException("размеры матриц не совпадают");
            }
        } else {
            throw new CalcException();
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[][] div = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < div.length; i++) {
                    for (int j = 0; j < div[0].length; j++) {
                        div[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(div);
            } else {
                throw new CalcException("деление на ноль");
            }
        } else throw new CalcException("операция невозможна");
    }
}