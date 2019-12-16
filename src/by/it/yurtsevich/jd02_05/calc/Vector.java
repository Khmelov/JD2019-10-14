package by.it.yurtsevich.jd02_05.calc;

import by.it.yurtsevich.jd02_05.Errors;
import by.it.yurtsevich.jd02_05.ResourceManager;

import java.util.Arrays;

class Vector extends Var {

    private static ResourceManager resourceManager=ResourceManager.INSTANCE;
    public double[] getValue() {
        return value;
    }

    private double[] value;

    Vector(double[] vector) {
        double[] newVector = new double[vector.length];
        System.arraycopy(vector, 0, newVector, 0, vector.length);
        this.value = newVector;
    }

    Vector(Vector vector) {
        double[] newVector = new double[vector.value.length];
        System.arraycopy(vector.value, 0, newVector, 0, vector.value.length);
        this.value = newVector;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{]", " ");
        strVector = strVector.replaceAll("[}]", " ");
        strVector = strVector.replaceAll("[,]", " ");
        strVector = strVector.trim();
        String[] strVectorArray = strVector.split(" ");
        double[] doubleVectorArray = new double[strVectorArray.length];
        for (int i = 0; i < doubleVectorArray.length; i++) {
            doubleVectorArray[i] = Double.parseDouble(strVectorArray[i]);
        }
        this.value = doubleVectorArray;
    }

    @Override
    public Var add(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Scalar) var).getValue();
            }
            return new Vector(sum);
        } else if (var instanceof Vector) {
            if (this.value.length == ((Vector) var).value.length) {
                double[] sum = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sum.length; i++) {
                    sum[i] = sum[i] + ((Vector) var).value[i];
                }
                return new Vector(sum);
            }
        }
        return super.add(var);
    }

    @Override
    public Var sub(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Scalar) var).getValue();
            }
            return new Vector(sub);
        } else if (var instanceof Vector) {
            if (this.value.length == ((Vector) var).value.length) {
                double[] sub = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sub.length; i++) {
                    sub[i] = sub[i] - ((Vector) var).value[i];
                }
                return new Vector(sub);
            }
        }
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double[] product = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < product.length; i++) {
                product[i] = product[i] * ((Scalar) var).getValue();
            }
            return new Vector(product);
        } else if (var instanceof Vector) {
            if (this.value.length == ((Vector) var).value.length) {
                double product = 0;
                for (int i = 0; i < this.value.length; i++) {
                    product = product + this.value[i] * ((Vector) var).value[i];
                }
                return new Scalar(product);
            }
        }
        return super.mul(var);
    }

    @Override
    public Var div(Var var) throws CalcException {
        if (var instanceof Scalar && ((Scalar) var).getValue() != 0) {
            if (((Scalar) var).getValue()==0)
                throw new CalcException(resourceManager.get(Errors.DIV_BY_ZERO));
            double[] div = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                div[i] = div[i] / ((Scalar) var).getValue();
            }
            return new Vector(div);
        }
        return super.div(var);
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
}
