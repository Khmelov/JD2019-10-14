package by.it.zimina.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y1 = 0;
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y1 = pow(7, a) - cos(x);
                y = y1 + y;
            }
            System.out.printf("При a=%3.2f Сумма y = %e\n", a, y);
        }

    }

    private static void step2() {
        for (double x = -6; x < 2; x = x + 0.5) {
            double beta;

            if (x / 2 <= -1 && x / 2 > -2) {
                beta = sin(x * x);
                double alfa = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%3.2f a =%e\n", x / 2, alfa);

            } else if (x / 2 < 0.2 && x / 2 > -1) {
                beta = cos(x * x);
                double alfa = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%3.2f a =%e\n", x / 2, alfa);

            } else if (x / 2 == 0.2) {
                beta = 1 / tan(x * x);
                double alfa = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%3.2f a =%e\n", x / 2, alfa);
            } else System.out.printf("При x/2=%3.2f результат не известен\n", x / 2);
        }
    }
}
