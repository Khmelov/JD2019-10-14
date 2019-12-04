package by.it.kazak.jd01_10;

class Bean {
    @Param(a = 10, b = 19)
    double sum (int a, int b) {
        return a+b;
    }
    @Param(a = 10, b = 19)
    static double max (int a, int b) {
        return Math.max(a, b);
    }
    @Param(a = 10, b = 19)
    static double min (int a, int b) {
        return Math.min(a, b);
    }
    double avg (int a, int b) {
        return (a+b)/2.0;
    }
}
