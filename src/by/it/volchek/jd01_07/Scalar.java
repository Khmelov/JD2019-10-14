package by.it.volchek.jd01_07;

public class Scalar extends Var{
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
}
