package by.it.zabauniuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Dispetcher {
    static final int timeFactor = 50;

    private static final int MAX_BUYERS = 100;
    private static int buyerCount = 0;
    private static double buyersInMarket = 0;

    static List<Cashier> cashierList = new ArrayList<>();

    private static final Object monitor = new Object();

    static boolean marketIsOpen() {
        synchronized (monitor) {
            return !planComplete() || buyersInMarket > 0;
        }
    }

    static boolean planComplete() {
        synchronized (monitor) {
            return buyerCount == MAX_BUYERS;
        }
    }

    static int buyerEnter() {
        synchronized (monitor) {
            buyerCount++;
            buyersInMarket++;
        }
        return buyerCount;
    }
    static void buyerExit() {
        synchronized (monitor) {
            buyersInMarket--;
        }
    }

    static void reset() {
        buyerCount = 0;
    }
}