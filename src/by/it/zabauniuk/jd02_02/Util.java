package by.it.zabauniuk.jd02_02;

public class Util {
    public static int randomUpTo (int max) {
        return randomFromTo(0, max);
    }

    public static int randomFromTo (int from, int to) {
        return from + (int)(Math.random()*(to-from+1));
    }


    public static void sleep(int timeout) throws InterruptedException
    {Thread.sleep(timeout / Dispetcher.timeFactor);
    }
}