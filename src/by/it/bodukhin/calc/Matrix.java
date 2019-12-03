package by.it.bodukhin.calc;

class Matrix extends Var {
    private double[][] value;
    public double[][] getValue() {return value;}

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(String  strMatrix) {
        String newStringLine = strMatrix.replaceAll("\\{", "").replaceAll(" ", "").replaceAll("},", "}");
        String[] stringArray = newStringLine.split("}");
        double[][] doubleArray = new double[stringArray.length][];

        for (int i = 0; i < stringArray.length; i++) {
            String[] rowStringArray = stringArray[i].split(",");
            doubleArray[i] = new double[rowStringArray.length];
            for (int j = 0; j < doubleArray[i].length; j++) {
                doubleArray[i][j] = Double.parseDouble(rowStringArray[j]);
            }
        }
        value = doubleArray;
    }

    @Override
    public Var add(Var other)throws CalcException {
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
    public Var sub(Var other) throws CalcException{
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
    public Var mul(Var other) throws CalcException{
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
            double[][] result = new double[value.length][((Matrix) other).value[0].length];
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

    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i <value.length-1 ; i++) {
            String delimeter = "";
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimeter).append(value[i][j]);
                delimeter = ", ";
            }
            sb.append("}, ");
        }
        for (int i = value.length-1; i <value.length ; i++) {
            String delimeter = "";
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimeter).append(value[i][j]);
                delimeter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
