package by.it.kharitonenko.jd02_03;

import by.it.kharitonenko.jd02_03.Utils.BuyerQueue;
import by.it.kharitonenko.jd02_03.Utils.Observer;
import by.it.kharitonenko.jd02_03.Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
Change SPEED value in Utils class to control speed (higher value == faster)
 */
public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("'+' symbol marks pensioner\n");
        System.out.print("semaphore in buyer class");
        Utils.sleep(2_000);
        System.out.println("MARKET IS OPEN");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        AtomicInteger buyerNumber = new AtomicInteger(0);
        while (Observer.marketOpened()) {
            int entranceCustomer = Utils.intRandom(Observer.getBirthControlA());
//            int entranceCustomer = Utils.intRandom(Observer.getBirthControl(t));
            for (int i = 0; i < entranceCustomer; i++) {
                Buyer buyer = new Buyer(buyerNumber.incrementAndGet());
                buyer.start();
            }
            Utils.sleep(1_000);
        }
        System.out.println("Waiting till market is empty...");

        threadPool.shutdown();
        while (!threadPool.awaitTermination(1, TimeUnit.MILLISECONDS));

        System.out.println("Market is closed!");
        System.out.println("Total number of customers: " + Observer.getAllBuyers());
    }
}
