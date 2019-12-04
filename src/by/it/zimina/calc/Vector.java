package by.it.zimina.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(Vector otherVector) {
        this.value = Arrays.copyOf(otherVector.value, otherVector.value.length);
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    Vector(String str){
        String[] sArray = str
                .replace("{", "")
                .replace("}", "")
                .replace(" ", "")
                .split(",");
        double[] d=new double[sArray.length];
        for (int i = 0; i < d.length; i++) {
            d[i]=Double.parseDouble(sArray[i]);
        }
        this.value=d;
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
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]= sub[i]-((Scalar)other).getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]= sub[i]-((Vector)other).value[i];
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value,this.value.length);
            double scalar = ((Scalar)other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i]*=scalar;
            }
            return new Vector(vector);
        }
        else if (other instanceof Vector) {
            double res=0;
            for (int i = 0; i < this.value.length; i++) {
                res+=this.value[i]*((Vector)other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i]= div[i]/((Scalar)other).getValue();
            }
            return new Vector(div);
        }
        else
            return super.div(other);
        }
    }

