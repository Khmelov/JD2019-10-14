package by.it.kazak.calc;

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
    public Var add(Var other) throws CalcException {
        Vector result = new Vector(this.value);
        if(other instanceof Vector){
            if(((Vector) other).value.length == result.value.length){
                for (int i = 0; i < result.value.length; i++) {
                    result.value[i] =result.value[i]+((Vector) other).value[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return result;
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + ((Scalar)other).getValue();
            }
            return result;
        }
        return super.add(other);
    }
    @Override
    public Var sub(Var other) throws CalcException {
        Vector result = new Vector(this.value);
        if(other instanceof Vector){
            if(((Vector) other).value.length == result.value.length){
                for (int i = 0; i < result.value.length; i++) {
                    result.value[i] =result.value[i]-((Vector) other).value[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return result;
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - ((Scalar)other).getValue();
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        Vector result = new Vector(this.value);
        if(other instanceof Vector){
            double value = 0;
            if(((Vector) other).value.length == result.value.length){
                for (int i = 0; i < result.value.length; i++) {
                    value +=result.value[i]*((Vector) other).value[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return new Scalar(value);
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] * ((Scalar)other).getValue();
            }
            return result;
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        Vector result = new Vector(this.value);
        if(other instanceof Scalar){
            if(((Scalar) other).getValue()==0) throw new CalcException("Деление на ноль.");
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] / ((Scalar)other).getValue();
            }
            return result;
        }
        return super.div(other);
    }



    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace("[", "{")
                .replace("]", "}");
    }
}
