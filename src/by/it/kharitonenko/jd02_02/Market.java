package by.it.kharitonenko.jd02_02;

import by.it.kharitonenko.jd02_02.Utils.BuyerQueue;
import by.it.kharitonenko.jd02_02.Utils.Observer;
import by.it.kharitonenko.jd02_02.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/*
Change SPEED value in Utils class to control speed (higher value == faster)
 */
public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("'+' symbol marks pensioner\n");
        Utils.sleep(2_000);
        System.out.println("MARKET IS OPEN");

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        int buyerNumber = 0;
        while (Observer.marketOpened()) {
            int entranceCustomer = Utils.intRandom(Observer.getBirthControlA());
//            int entranceCustomer = Utils.intRandom(Observer.getBirthControl(t));
            for (int i = 0; i < entranceCustomer; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                threads.add(buyer);
                buyer.start();
            }
            Utils.sleep(1_000);
        }

        for (Thread buyer : threads) {
            buyer.join();
        }

//        for (Thread thread : threads) {
//            thread.notifyAll();
//            thread.join();
//        }

        System.out.println("Market is closed!");
        System.out.println("Total number of customers: " + Observer.getAllBuyers());
    }
}
