package by.it.kazak.jd01_08;

import java.util.Arrays;

class Vector extends Var {

   private double[] value;
   Vector(double[] value) {this.value = Arrays.copyOf(value,value.length);}
   Vector(Vector vector) {this.value = vector.value;}
   public double[] getValue() {return value;}
   Vector(String strVector){
       String[] array_str = strVector.replaceAll("[{}]", "").split("[^\\d.]+");
       double[] array_double = new double[array_str.length];
       for (int i = 0; i < array_str.length; i++) {
           array_double[i] = Double.parseDouble(array_str[i]);
       }
       this.value = array_double;
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
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else
            return super.add(other);
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
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double res = 0;
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                res += result[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        } else
            return super.add(other);
    }
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            return null;
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace("[", "{")
                .replace("]", "}");
    }
}
