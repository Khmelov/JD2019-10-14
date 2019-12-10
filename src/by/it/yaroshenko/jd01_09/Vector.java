package by.it.yaroshenko.jd01_09;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }
    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }
    Vector(String strValue) {
        String[] array_str = strValue.replaceAll("[{}]", "").split("[^\\d.]+");
        double[] array_double = new double[array_str.length];
        for (int i = 0; i < array_str.length; i++) {
           array_double[i]=Double.parseDouble(array_str[i]);
        }
        this.value=array_double;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]+((Scalar) other).getValue();
            }
            return new Vector(array);
        }else if (other instanceof Vector){
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]+((Vector) other).value[i];
            }
            return new Vector(array);
        }

        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]-((Scalar) other).getValue();
            }
            return new Vector(array);
        }else if (other instanceof Vector){
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]-((Vector) other).value[i];
            }
            return new Vector(array);
        }

        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
            if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]*((Scalar) other).getValue();
            }
            return new Vector(array);
        }else if (other instanceof Vector){
            double sum=0;
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]*((Vector) other).value[i];
                sum+=array[i];
            }
            return new Scalar(sum);
        }

        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i]=array[i]/((Scalar) other).getValue();
            }
            return new Vector(array);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element:value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
