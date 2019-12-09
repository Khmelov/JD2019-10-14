package by.it.yurtsevich.calc11;


class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(value + ((Scalar) other).value);
        } else
        return other.add(this);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value - ((Scalar) other).value);
        }
        else
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value * ((Scalar) other).value);
        }
        else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value / ((Scalar) other).value);
        }
        else
            return super.div(this);
    }

    Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }

    Scalar(String strScalar) {
        this.value=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}