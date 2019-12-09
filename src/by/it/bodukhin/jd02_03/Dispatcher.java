package by.it.bodukhin.jd02_03;

import by.it.akhmelev.jd02_03.Cashier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
    static final int PLAN = 100;
    private final static AtomicInteger numberOfCashier = new AtomicInteger(1);
    final static AtomicInteger countBuyer = new AtomicInteger(0);
    final static AtomicInteger countCompeteBuyers = new AtomicInteger(0);
    static int kSpeed = 1000;
    ExecutorService threadPool = Executors.newFixedThreadPool(5);

    @Override
    public void run() {
        while (countCompeteBuyers.get() < PLAN) {
                for (int i =numberOfCashier.get(); i <= 5; i++) {
                    if (QueueBuyer.getCount() > (numberOfCashier.get()*5)) {
                    Cashier cashier = new Cashier(i);
                    threadPool.execute(cashier);
                    numberOfCashier.getAndIncrement();
                }
            }
            Helper.sleep(1000);
        }
        //threadPool.shutdown();
    }
}

