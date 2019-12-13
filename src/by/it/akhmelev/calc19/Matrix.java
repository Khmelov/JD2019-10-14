package by.it.akhmelev.calc19;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(Matrix other) {
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strValue) {

    }

    @Override
    public String toString() {
        return "{{some Matrix}}";
    }
}
