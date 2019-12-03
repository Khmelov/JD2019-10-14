package by.it.sermyazhko.Calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value,vector.value.length);
    }

    public Vector(String strVector){
        String str = strVector.replaceAll("[{}]","");
        String[] arr = str.split(",");
        double[] mas = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i] = Double.parseDouble(arr[i]);
        }
        this.value = Arrays.copyOf(mas,mas.length);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if(i == value.length-1)
            {
                break;
            }
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
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
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < this.value.length ; i++) {
                result[i] -= scalarValue;
            }
            return new Vector(result);
        }
        else if (other instanceof Vector && value.length == ((Vector) other).value.length){
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < this.value.length ; i++) {
                result[i] *= scalarValue;
            }
            return new Vector(result);
        }
        else if (other instanceof Vector && value.length == ((Vector) other).value.length){
            double[] result = new double[value.length];
            double res = 0;
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                res += result[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        else{
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < this.value.length ; i++) {
                result[i] /= scalarValue;
            }
            return new Vector(result);
        }
        else{
            return super.div(other);
        }
    }
}
