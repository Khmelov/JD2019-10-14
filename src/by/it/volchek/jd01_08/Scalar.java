package by.it.volchek.jd01_08;

public class Scalar extends Var implements Operation{
    double value;
    Scalar(double value){
        this.value = value;
    }
    Scalar(Scalar scalar){
       this.value = scalar.value;
    }
    Scalar(String strScalar){
        this.value = Double.valueOf(strScalar);
    }
    public String toString(){
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            return new Scalar(this.value+((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            return new Scalar(this.value-((Scalar) other).value);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            return new Scalar(this.value*((Scalar) other).value);
        }

        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            if(((Scalar) other).value!=0){
            return new Scalar(this.value/((Scalar) other).value);}
            else {super.div(other);}
        }
        return other.div(this);
    }
}
