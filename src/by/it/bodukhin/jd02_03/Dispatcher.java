package by.it.bodukhin.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
    static Semaphore semChoosingGoods = new Semaphore(20);
    static Semaphore semPrintToConsole = new Semaphore(1);
    static final int PLAN = 100;
    final static AtomicInteger numberOfCashier = new AtomicInteger(1);
    final static AtomicInteger countBuyer = new AtomicInteger(0);
    final static AtomicInteger countCompeteBuyers = new AtomicInteger(0);
    static int kSpeed = 1000;
    static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    @Override
    public void run() {
        while ((countCompeteBuyers.get() < PLAN) && (numberOfCashier.get()<6)) {
            int j = numberOfCashier.get();
                    if (QueueBuyer.getCount() > (numberOfCashier.get()*5)) {
                    Cashier cashier = new Cashier(j);
                    threadPool.execute(cashier);
                    numberOfCashier.getAndIncrement();
            }
            Helper.sleep(1000);
        }
        threadPool.shutdown();
    }
}

