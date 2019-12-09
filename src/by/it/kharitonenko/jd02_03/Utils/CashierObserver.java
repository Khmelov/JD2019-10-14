package by.it.kharitonenko.jd02_03.Utils;

import by.it.kharitonenko.jd02_03.Cashier;

import java.util.ArrayList;
import java.util.List;

public class CashierObserver {
    public static List<Thread> cashierList = new ArrayList<>();
    //max allowed cashiers
    static int allowedCashiers = 0;
    //free cashier slots
    static int freeSpace = 0;
    static int occupiedSlot = 0;

    public static int getOccupiedSlot() {
        return occupiedSlot;
    }

    //checking buyer queue size
    //TODO cashiers working free space etc
    public synchronized static void buyerQueueCheck() {
        allowedCashiers = BuyerQueue.getQueueSize() / 5 + 1;
        if (allowedCashiers > 5) {
            allowedCashiers = 5;
            freeSpace = 5 - occupiedSlot;
        }
        freeSpace += allowedCashiers - occupiedSlot;
    }

    public static int getNumberOfWorkingCashiers() {
        return freeSpace;
    }

    public static void createCashiers() {
        //change number of cashiers
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            cashierList.add(thread);
            thread.start();
        }
    }

    public static boolean freeCashiers() {
        return freeSpace > 0;
    }

    public synchronized static void getSpace() {
        freeSpace--;
        occupiedSlot++;
    }

    public synchronized static void freeSpace() {
        freeSpace++;
        occupiedSlot--;
    }
}
