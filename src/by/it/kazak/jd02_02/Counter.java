package by.it.kazak.jd02_02;

import java.util.HashMap;

class Counter {

    private static final Object monitorCounters = new Object();
    private static final Object monitorCashiers = new Object();

    final static int finishTime = 60;
    static int kSpeed = 10000;
    private static final int PLAN = 100;
    private static volatile int buyerCounter = 0;
    private static volatile int buyerInMarket = 0;
    private static volatile int cashiersCounter = 0;

    static synchronized boolean marketOpened() {
        int countCompleteBuyer = 0;
        return buyerCounter + countCompleteBuyer < PLAN;
    }

    static HashMap<String, Double> getGoods() {
        return products;
    }

    static void newBuyer() {
        synchronized (monitorCounters) {
            buyerCounter++;
            buyerInMarket++;
        }
    }

    static void deleteBuyer() {
        synchronized (monitorCounters) {
            buyerInMarket--;
        }
    }

    static void newCashier() {
        synchronized (monitorCashiers) {
            cashiersCounter++;
        }
    }

    static void deleteCashier() {
        synchronized (monitorCashiers) {
            cashiersCounter--;
        }
    }

    static int getBuyerInMarket() {
        return buyerInMarket;
    }

    static boolean planComplete() {
        return buyerCounter != PLAN;
    }

    static HashMap<String, Double> getListOfGoods() {
        return new HashMap<>(products);
    }

    private static HashMap<String, Double> products = new HashMap<String, Double>() {
        {
            put("potato", 2.0);
            put("milk", 4.1);
            put("bread", 1.5);
            put("eggs", 3.2);
            put("bubble gum", 1.2);
            put("rice", 1.7);
            put("peanuts", 4.3);
            put("water", 0.5);
        }
    };

}
