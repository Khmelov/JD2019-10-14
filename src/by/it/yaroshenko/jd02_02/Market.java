package by.it.yaroshenko.jd02_02;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
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
        System.out.println("Market closed");
    }
}
