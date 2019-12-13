package by.it.komarov.jd01_10;

public class Bean {

    public double sum(int a, int b){
        return a + b;
    }

    @Param(a = 4, b = 6)
    public double avg(int a, int b){
        return (a + b) / 2.0;
    }

    @Param(a = 8, b = 4)
    public static double min(int a, int b){
        return Math.min(a, b); // a < b ? a : b
    }

    @Param(a = 3, b = 4)
    public static double max(int a, int b){
        return Math.max(a, b); // a > b ? a : b
    }
}
