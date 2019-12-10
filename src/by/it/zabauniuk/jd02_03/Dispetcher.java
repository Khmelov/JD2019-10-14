package by.it.zabauniuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispetcher {
    static int kSpeed = 10;

    private static final int MAX_BUYERS = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);

    static  boolean marketIsOpened() {
        return buyerCounter.get() < MAX_BUYERS || buyerInMarket.get() > 0;
    }

    static void buyerInMarket() {
        buyerCounter.incrementAndGet();
        buyerInMarket.incrementAndGet();
    }

    static  void  buyerLeaveMarket() {
        buyerInMarket.getAndDecrement();
    }

    static boolean planComplete() {
        return buyerCounter.get() != MAX_BUYERS;
    }
}