package by.it.bodukhin.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {
    static final Integer fakeMonitor = 0;
    static final int PLAN = 100;
    static volatile int countBuyer = 0;
    static volatile int countCompeteBuyers = 0;
    static int kSpeed = 1000;
    static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countCompeteBuyers < PLAN) {
            if ((QueueBuyer.getCount() > cashiers.size() * 5) && (cashiers.size() < 5)) {
                Thread cashier = new Thread(new Cashier(cashiers.size()+1));
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }
    }
}

