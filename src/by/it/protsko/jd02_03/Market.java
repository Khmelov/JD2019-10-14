package by.it.protsko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Market {
    private final static AtomicInteger numberBuyer = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened!");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        while (Dispather.marketOpen()) {
            createBuyer();
            Thread.sleep(1000 / Dispather.speedProcess);
        }

        threadPool.shutdown();
        while (!threadPool.awaitTermination(1, TimeUnit.MILLISECONDS)) ;
        System.out.println("\nMarket closed!");
    }

    private static void createBuyer() {
        int countBuyer = Helper.randomValue(0, 2);
        for (int j = 1; j <= countBuyer; j++) {
            Buyer buyer;
            if (Dispather.marketOpen()) {
                if (numberBuyer.getAndIncrement() % 4 != 0) {
                    buyer = new Buyer(numberBuyer.get());

                } else {
                    buyer = new Buyer(numberBuyer.get(), true);
                }
                buyer.start();
            }
        }
    }
}
