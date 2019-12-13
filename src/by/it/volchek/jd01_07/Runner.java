package by.it.volchek.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var scalar = new Scalar(new Scalar(2.3));
        Var scalar2 = new Scalar("3.2");
        System.out.println(scalar.toString() + " " + scalar2.toString());
        Var vector = new Vector("{1.0, 3.5, 6.1");
        System.out.println(vector.toString());
    }
}
