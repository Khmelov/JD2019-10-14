package by.it.yurtsevich.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static by.it.yurtsevich.jd02_03.Dispatcher.planComplete;
import static by.it.yurtsevich.jd02_03.Util.random;
import static by.it.yurtsevich.jd02_03.Util.sleep;

public class Market {
    public static void main(String[] args)  {
        int numberBuyer = 0;
        List<Buyer> buyerList = new ArrayList<>(200);
        System.out.println("Market opened");

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            pool.execute(cashier);
           // Thread thread = new Thread(cashier);
           // thread.start();
        }
        while (!planComplete()) {
            int maxBuyers = random(2);
            for (int i = 0; i < maxBuyers; i++) {
                if (!planComplete()) {
                    Buyer buyer = new Buyer();
                    buyerList.add(buyer);
                    buyer.start();
                }
            }
            sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("JOIN ERROR: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        pool.shutdown();
        while (!pool.isTerminated())
        {
            Thread.yield();
        }
        System.out.println("Market closed");
    }
}

