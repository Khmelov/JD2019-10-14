package by.it.akhmelev.calc19;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }

    Scalar(String strScalar) {
        this.value=Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(this.value+((Scalar) other).value);
        }
        else
            return other.add(this);
    }
    @Override
    public Var sub(Var other)  throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(this.value-((Scalar) other).value);
        }
        else
            return other.sub(this).mul(new Scalar(-1));
    }
    @Override
    public Var mul(Var other)  throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(this.value*((Scalar) other).value);
        }
        else
            return other.mul(this);
    }
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double z = ((Scalar) other).value;
            if (z==0)
                throw new CalcException("деление на 0");
            return new Scalar(this.value/z);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
