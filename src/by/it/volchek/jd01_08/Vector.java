package by.it.volchek.jd01_08;

public class Vector extends Var {
    double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[\\{\\} ]", "");
        String[] array = strVector.split(",");
        double[] x = new double[array.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = Double.parseDouble(array[i]);
        }
        this.value = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","))
                .deleteCharAt(stringBuilder.lastIndexOf(" "))
                .append("}");
        return stringBuilder.toString();
    }
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
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
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
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
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
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
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) return super.div(other);
            double scalarValue = ((Scalar) other).getValue();
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
