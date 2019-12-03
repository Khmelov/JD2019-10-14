package by.it.kharitonenko.calc;

class Vector extends Var {
    double[] value;

    Vector(double[] value) {
        this.value = value;
    }
    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }
    Vector(String strVector) {
        strVector = strVector.replaceAll("[}{ ]","");
        String[] tempStr = strVector.split(",");
        this.value = new double[tempStr.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = Double.valueOf(tempStr[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).value;
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] += scalarValue;
                }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length)
        {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] += ((Vector) other).value[i];
                }
            return new Vector(result);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).value;
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalarValue;

            }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).value;
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Vector) other).value[i];
            }
            double resultMulByVector = 0.0;
            for (double value : result) {
                resultMulByVector += value;
            }
            return new Scalar(resultMulByVector);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) return super.div(other);
            double scalarValue = ((Scalar) other).value;
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalarValue;
            }
                return new Vector(result);
        }
        return super.div(other);
    }
}
