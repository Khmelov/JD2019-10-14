package by.it.kharitonenko.calc;

class Matrix extends Var {
    double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix) {
        String[] strArray = strMatrix.replaceAll("\\},", "xxx").
                replaceAll(" ", "").
                replaceAll("\\}","").
                replaceAll("\\{","").
                trim().split("xxx");

        String[] strRowMatrix = strArray[0].trim().split("[,]");
        double[][] lineMatrix = new double[strArray.length][strRowMatrix.length];

        for (int i = 0; i < strArray.length; i++) {
            strRowMatrix = strArray[i].trim().split("[,]");
            for (int j = 0; j < strRowMatrix.length; j++) {
                lineMatrix[i][j] = Double.parseDouble(strRowMatrix[j]);
            }
        }
        this.value = lineMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{");
            for (int j = 0; j <this.value[i].length; j++) {
                sb.append(delimiter).append(this.value[i][j]);
                delimiter = ", ";
            }
            delimiter = "";
            if (i!=this.value.length-1) sb.append("}, ");
            else
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar)
        {
            double[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] += ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix &&
                ((Matrix) other).value.length == this.value.length &&
                ((Matrix) other).value[0].length == this.value[0].length) {
            double[][] temp = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(temp);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar)
        {
            double[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] -= ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Matrix &&
                ((Matrix) other).value.length == this.value.length &&
                ((Matrix) other).value[0].length == this.value[0].length) {
            double[][] temp = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(temp);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar)
        {
            double[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = temp[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        if (other instanceof Vector &&
            this.value[0].length==((Vector) other).value.length) {
            double[] temp = new double[((Vector) other).value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Vector) other).value.length; j++) {
                    temp[i] += this.value[i][j]*((Vector) other).value[j];
                }
            }
            return new Vector(temp);
        }

        if (other instanceof Matrix &&
            this.value[0].length == ((Matrix) other).value.length) {
            double[][] temp = new double[this.value[0].length][((Matrix) other).value.length];
            double tempDoubleValue;
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        temp[i][j] += value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(temp);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar &&
            ((Scalar) other).value != 0)
        {
            double[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = temp[i][j] / ((Scalar) other).value;
                }
            }
            return new Matrix(temp);
        }
        return super.div(other);
    }
}
