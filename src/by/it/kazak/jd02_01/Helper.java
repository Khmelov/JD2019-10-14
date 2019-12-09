package by.it.kazak.jd02_01;

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
            Thread.sleep(timeout / Counter.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
