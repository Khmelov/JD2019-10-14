package by.it.kazak.jd01_07;


class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }
    public  Scalar(String strScalar){
        this.value=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
