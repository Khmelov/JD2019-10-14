package by.it.kharitonenko.jd02_02;

import by.it.kharitonenko.jd02_02.Utils.BuyerQueue;
import by.it.kharitonenko.jd02_02.Utils.CashierObserver;
import by.it.kharitonenko.jd02_02.Utils.Observer;
import by.it.kharitonenko.jd02_02.Utils.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashier implements Runnable {
    private String cashierName;
    private final Lock lock = new ReentrantLock();

    public Cashier(int number) {
        cashierName = "Cashier# " + number;
    }

    @Override
    public void run() {
        System.out.println(cashierName + " started working.");
        while (!Observer.marketClosed()) {
            Buyer currentBuyer = BuyerQueue.extract();
            if (currentBuyer != null) {
                System.out.println(cashierName + " <--start--> " + currentBuyer);
                Utils.sleep(Utils.intRandom(2000, 5000));
                System.out.println(cashierName + " <--" + currentBuyer.getBasket().checkBasket() + "--> " + currentBuyer);
                System.out.println(cashierName + " <--cheque $" + currentBuyer.getCheque() + "--> " + currentBuyer);
                synchronized (currentBuyer) {
                    currentBuyer.notify();
                }
            } else {
//                //closing cashier
//                //TODO deadlock
//                CashierObserver.freeSpace();
//                lock.lock();
//                while (!CashierObserver.freeCashiers()) {
//                    CashierObserver.buyerQueueCheck();
//                    if (Observer.marketClosed()) {
//                        break;
//                    }
//                }
//            }
//            lock.unlock();
//            System.out.println(cashierName + " closed.");
                Utils.sleep(1);
            }
        }
        System.out.println(cashierName + " finished his work.");
    }
}