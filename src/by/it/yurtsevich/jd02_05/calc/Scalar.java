package by.it.yurtsevich.jd02_05.calc;

import by.it.yurtsevich.jd02_05.Errors;
import by.it.yurtsevich.jd02_05.ResourceManager;

class Scalar extends Var {

    private double value;

    private static ResourceManager resourceManager=ResourceManager.INSTANCE;

    public double getValue() {
        return value;
    }

    Scalar(double scalar) {
        this.value = scalar;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public Var add(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double sum = this.value + ((Scalar) var).value;
            return new Scalar(sum);
        } else return var.add(this);
    }

    @Override
    public Var sub(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double sub = this.value - ((Scalar) var).value;
            return new Scalar(sub);
        } else {
            Scalar minus = new Scalar(-1);
            return var.mul(minus).add(this);
        }
    }

    @Override
    public Var mul(Var var) throws CalcException {
        if (var instanceof Scalar) {
            double product = this.value * ((Scalar) var).value;
            return new Scalar(product);
        } else {
            return var.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar && ((Scalar) other).value != 0) {
            if (((Scalar) other).value==0)
                throw new CalcException(resourceManager.get(Errors.DIV_BY_ZERO));
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
