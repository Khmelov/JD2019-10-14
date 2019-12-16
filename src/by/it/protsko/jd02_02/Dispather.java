package by.it.protsko.jd02_02;

class Dispather {
    volatile static int countBuyer = 0;
    static final int speedProcess = 1000;
    static final double pensionerSpeedProcess = 1.5;

    private static final int PLAN = 100;
    private volatile static int countBuyerInMarket = 0;
    private volatile static int countCompleteBuyer = 0;

    static synchronized void buyerInMarket() {
        countBuyerInMarket++;
    }

    static synchronized void buyerLeaveMarket() {
        countBuyerInMarket--;
        countCompleteBuyer++;
    }

    static synchronized boolean marketOpen() {
        return (countBuyerInMarket + countCompleteBuyer) < PLAN;
    }

    static boolean marketClosed() {
        return countCompleteBuyer == PLAN;
    }
}
