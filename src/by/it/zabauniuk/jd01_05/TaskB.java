package by.it.zabauniuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = (pow(7, a)) * 6;

            for (int x = 1; x <= 6; x++) {
                y = -cos(x) + y;
            }
            System.out.printf("При a=%6.2f Cумма y = %E\n", a, y);
        }

    }


    private static void step2() {
        double b = 0;
        double x;
        boolean isOk=false;
        for (x=-5.5; x<2; x=x+0.5) {
            isOk = false;

            if ((x / 2 > -2) && (x / 2 <= -1)) {
                isOk = true;
                b = sin(x * x);
            }
            if ((x / 2 > -1) && (x / 2 < 0.2)) {
                isOk = true;
                b = cos(x * x);
            }
            if (x / 2 == 0.2) {
                isOk = true;
                b = 1 / tan(x * x);
            }
            if (isOk == true) {
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f Сумма a=%E\n", x / 2, a);
            } else {
                System.out.printf("При x/2=%3.2f вычисления не определены\n", x / 2);
            }
        }

    }
}
