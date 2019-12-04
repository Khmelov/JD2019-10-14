package by.it.konovalova.calc;


import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("\\{", "");
        strVector = strVector.replaceAll("\\}", "");
        String[] arr = strVector.split(",");
        double[] arr1 = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = Double.parseDouble(arr[i]);
        }
        this.value = arr1;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
      //  if (other instanceof Vector && value.length==((Vector) other).value.length) {
        if (value.length!=((Vector) other).value.length) throw new CalcException("Разные длины векторов");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];

            }
            return new Vector(res);
        } else
            return super.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
      //  if (other instanceof Vector && value.length==((Vector) other).value.length) {
        if (value.length!=((Vector) other).value.length) throw new CalcException("Разные длины векторов");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];

            }
            return new Vector(res);
        } else
            return super.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
      //  if (other instanceof Vector && value.length==((Vector) other).value.length) {
        if (value.length==((Vector) other).value.length) throw new CalcException("Разные длины векторов");
            double[] res = Arrays.copyOf(value, value.length);
            int resMul = 0;
            int i = 0;

            for (double n : res) {
                resMul += n * ((Vector) other).value[i];
                i++;
            }
            return new Scalar(resMul);
        } else
            return super.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
       // if (other instanceof Scalar && ((Scalar) other).getValue()!=0) {
        if (((Scalar) other).getValue()==0) throw new CalcException("Деление на ноль");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();

            }
            return new Vector(res);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
