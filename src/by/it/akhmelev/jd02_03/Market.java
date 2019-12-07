package by.it.akhmelev.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }


        int numberBuyer = 0;
        while (Dispatcher.marketOpened()) {
            int currentCount = Helper.random(2);
            for (int i = 0; i <= currentCount; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }

        threadPool.shutdown();
        //noinspection StatementWithEmptyBody
        while (!threadPool.awaitTermination(1, TimeUnit.MILLISECONDS));
        System.out.println("Market closed");
    }

}
