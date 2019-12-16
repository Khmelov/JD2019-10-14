package by.it.yurtsevich.jd02_01;

public class Dispacther {
    static int countBuyer=0;
    static int kSpeed = 1000;
    private static volatile int buyerInMarket = 0;

    static synchronized void buyerInMarket() {
        buyerInMarket++;

    }

    static synchronized void buyerLeftMarket() {
        buyerInMarket--;

    }

    static int getBuyerInMarket() {
        return buyerInMarket;
    }
}
