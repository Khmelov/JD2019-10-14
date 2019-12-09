package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }


        int numberBuyer = 0;
        while (Dispatcher.marketOpened()) {
            int currentCount = Helper.random(2);
            for (int i = 0; i <= currentCount; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    threads.add(buyer);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Market closed");
    }

}
