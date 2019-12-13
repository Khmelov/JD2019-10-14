package by.it.yaroshenko.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        ArrayList<Thread> threads = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            executorService.execute(cashier);
        }
        int numberBuyer = 0;
        while (Dispatcher.marketIsOpened()) {


            int currentCount = Helper.random(2);
            for (int i = 0; i < currentCount; i++) {
                if (Dispatcher.marketIsOpened()) {
                    Dispatcher.marketIsOpened();
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
        executorService.shutdown();
        //noinspection StatementWithEmptyBody
        while(!(executorService.awaitTermination(1, TimeUnit.MILLISECONDS)));
        System.out.println("Market closed");
    }
}
