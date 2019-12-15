package by.it.komarov.jd02_06;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) { this.value = value; }

    Vector(Vector vector)  { this.value = vector.value; }

    Vector(String strValue){
        String[] str = strValue.replace('{', ' ').replace('}', ' ').trim().split(",\\s*");
        value = new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add(Var other)
    {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Scalar) other).getValue();
            }
            return new Vector(sum);
        } else
            if (other instanceof Vector) {
                double[] sum = Arrays.copyOf(value, value.length);
                for (int i = 0; i < sum.length; i++) {
                    sum[i] += ((Vector) other).value[i];
                }
                return new Vector(sum);
            }
                return super.add(other);
    }

    @Override
    public Var sub(Var other)
    {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else
            if (other instanceof Vector &&
                value.length == ((Vector) other).value.length) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {

            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Scalar) other).getValue();
            }
            return new Vector(mul);
        } else
            if (other instanceof Vector &&
                    value.length == ((Vector) other).value.length) {
                double result = 0;
                for (int i = 0; i < this.value.length; i++) {
                    result += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(result);
            }
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue()!=0) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else
            return super.div(other);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";

        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
