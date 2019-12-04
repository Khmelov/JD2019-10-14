package by.it.zimina.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    public Vector(String strVector) {
        strVector=strVector.replaceAll("\\}", "");
        strVector=strVector.replaceAll("\\{","");
        String[] arr=strVector.split(",");
        double[] vector =new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vector[i]=Double.parseDouble(arr[i]);
        }
        this.value= vector;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element: value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return  sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i]= sum[i]+((Scalar)other).getValue();
            }
            return new Vector(sum);
        }
        else if (other instanceof Vector) {
            double[] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i]= sum[i]+((Vector)other).value[i];
            }
            return new Vector(sum);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]= sub[i]+((Scalar)other).getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]= sub[i]+((Vector)other).value[i];
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
