package by.it.baranovskaya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y;
        for (double a = 0; a <= 2; a = a + 0.2) {
            y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
                    System.out.println("Значение при а=" + a + " составляет " + y);
                }
            }

        private static void step2 () {
            double a, b;
            for (double x = -5.5; x < 2; x = x + 0.5) {
                b = 0;
                if ((x / 2) > -2 & (x / 2) <= -1) {
                    b = sin(x * x);
                }
                if ((x / 2) > -1 & (x / 2) <= 0.2) {
                    b = cos(x * x);
                }
                if ((x / 2) == 0.2) {
                    b = tan(x * x);
                }
                if (b == 0) {
                    System.out.println("При x=" + x/2 + " значение не определено!");
                }
                else {
                    a = log10(abs(b + 2.74));
                    System.out.println("При х=" + x / 2 + " значение функции составит " + a);
                }
            }
        }
    }

