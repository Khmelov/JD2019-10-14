package by.it.baranovskaya.jd01_09;


import java.util.Arrays;

public class Vector extends Var {
    public double[] value;

    public double[] getValue() {
        return value;
    }
    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public Vector(Vector vector)  { this.value = vector.value; }
    public Vector(String strVector) {
        String[] str = strVector.replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add (Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else
            return super.add(other);
    }
    @Override
    public Var sub (Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul (Var other) {
        double res = 0;
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                res = (result[i] * ((Vector) other).value[i]) + res;
            }
            return new Scalar(res);
        } else
            return super.mul(other);
    }

    @Override
    public Var div (Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else
            return super.div(other);
    }

@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    sb.append("{");
            String delimeter = "";
            for(double element : value) {
                sb.append(delimeter).append(element);
                delimeter = ", ";
            }
            sb.append("}");
            return sb.toString();
    }
}