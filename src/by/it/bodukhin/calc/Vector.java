package by.it.bodukhin.calc;

class Vector extends Var {
    private double[] value;
    public double[] getValue() {return value;}

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector(String strVector) {
        String[] str = strVector.replace("{","")
                .replace("}","")
                .split(",");
        value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
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
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalarValue;
            }
            return new Vector(result);
        } else if (other instanceof Vector &&
                value.length == ((Vector) other).value.length
        ) {
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result = result + this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(result);
        } else
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar && ((Scalar) other).getValue()!=0) {
            double scalarValue = ((Scalar) other).getValue();
                double[] result = new double[value.length];
                System.arraycopy(value, 0, result, 0, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] / scalarValue;
                }
                return new Vector(result);
            } else
        return super.div(other);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for(double element : value) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
