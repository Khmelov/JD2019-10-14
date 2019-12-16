package by.it.yurtsevich.jd02_01;

public class Util {
    public static int random(int max) {
        return random(0, max);
    }

    public static int random(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispacther.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
