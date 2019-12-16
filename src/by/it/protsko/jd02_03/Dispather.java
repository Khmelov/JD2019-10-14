package by.it.protsko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispather {
    private final static AtomicInteger countBuyer = new AtomicInteger(0);
    static final int speedProcess = 1000;
    static final double pensionerSpeedProcess = 1.5;
    private static final int PLAN = 100;

    private final static AtomicInteger countBuyerInMarket = new AtomicInteger(0);
    private final static AtomicInteger countCompleteBuyer = new AtomicInteger(0);

    static void buyerInMarket() {
        countBuyerInMarket.getAndIncrement();
    }

    static void buyerLeaveMarket() {
        countBuyerInMarket.getAndDecrement();
        countCompleteBuyer.getAndIncrement();
    }

    static boolean marketOpen() {
        return (countBuyerInMarket.get() + countCompleteBuyer.get()) < PLAN;
    }

    static boolean marketClosed() {
        return countCompleteBuyer.get() == PLAN;
    }
}
