package by.it.zabauniuk.jd01_10;

public class Bean {

    @Param(a = 8, b = 5)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 14, b = 3)
    double max(int a, int b) {
        return (a > b ? a : b);
    }


    @Param(a = 11, b = 7)
    static double min(int a, int b) {
        return (a < b ? a : b);
    }

    double avg(int a, int b) {
        return ((a + b) / 2.0);
    }
}

