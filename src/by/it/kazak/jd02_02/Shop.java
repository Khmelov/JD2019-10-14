package by.it.kazak.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {
        System.out.println("------------shop is opened---------------");
        List<Thread> threads = new ArrayList<>();
        int numberCashiers = 0;

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(++numberCashiers);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);

        }

        int numberBuyer = 0;
        int time = 0;

        while (Counter.planComplete()) {
            if (time <= 30) {
                int count = Helper.random(2);
                if (!(Counter.getBuyerInMarket() >= time + 10)) {
                    for (int n = 0; n < count; n++) {
                        if (Counter.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();
                            threads.add(buyer);
                        }
                    }
                }
                time++;
                Helper.sleepThread(1000);

            } else {
                int count = Helper.random(2);
                if (Counter.getBuyerInMarket() <= 40 + (30 - time)) {
                    for (int n = 0; n < count; n++) {
                        if (Counter.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();
                            threads.add(buyer);
                        }
                    }
                }
                time++;
                Helper.sleepThread(1000);
            }
            if (time == Counter.finishTime) time = 0;
        }

        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------shop is closed-------------");
    }
}
