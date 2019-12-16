package by.it.protsko.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class ChashBoxService extends Thread {
    static List<Thread> cashierList = new ArrayList<>();
    private int countCashier = 0;


    @Override
    public void run() {
        while (!Dispather.marketClosed()) {
            if ((cashierList.size() < 5) && (QueueBuyer.getQueueSize() >= (cashierList.size() * 5) + 1)) {
                Cashier cashier = new Cashier(++countCashier);
                Thread thread = new Thread(cashier);
                synchronized (cashierList) {
                    cashierList.add(thread);
                    thread.start();
                }
            }
            try {
                Thread.sleep(Helper.randomValue(100, 500) / Dispather.speedProcess);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
