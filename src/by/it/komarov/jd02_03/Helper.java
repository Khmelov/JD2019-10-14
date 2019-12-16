package by.it.komarov.jd02_03;

import java.util.Random;

class Helper {

    private static Random generator = new Random(System.nanoTime());

    static int random(int max) {
        return random(0, max);
    }

    static int random(int start, int end) {
        return start + generator.nextInt(end - start);
    }

    static void sleepThread(int timeout) {
        try {
            Thread.sleep(timeout / Counter.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
