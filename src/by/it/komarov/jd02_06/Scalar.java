package by.it.komarov.jd02_06;

class Scalar extends Var{

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value)   { this.value = value; }

    Scalar(String str)     { this.value = Double.parseDouble(str); }

    Scalar(Scalar scalar)  { this.value = scalar.value; }

    @Override
    public String toString() { return Double.toString(value); }

    @Override
    public Var add(Var other) throws CalcException{
       if(other instanceof Scalar){
           double sum = this.value + ((Scalar) other).value;
           return new Scalar(sum);
       } else
           return other.add(this);
           // (matrix or vector) + scalar
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if(other instanceof Scalar){
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return new Scalar(-1).mul(other).add(this);
            // -1 * {1, 2, 3} + 5
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if(other instanceof Scalar){
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if(other instanceof Scalar){
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else
            return super.div(other);
    }
}
