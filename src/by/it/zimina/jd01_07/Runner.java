package by.it.zimina.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        Var v2 = new Vector(new double[]{1, 2, 3});
        Var v3 = new Matrix(new double[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }
}
