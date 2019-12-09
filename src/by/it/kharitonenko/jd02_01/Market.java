package by.it.kharitonenko.jd02_01;

import by.it.kharitonenko.jd02_01.Utils.Observer;
import by.it.kharitonenko.jd02_01.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/*
Change SPEED in Utils class to control speed (higher value == faster)
 */
public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("'+' symbol marks pensioner\n" +
                "Market gives updates every 10 seconds\n" +
                "You can see how much money customer has when he enters and when he leaves\n\n");
        Utils.sleep(5_000);
        System.out.println("MARKET IS OPEN");
        List<Buyer> customers = new ArrayList<>();
        for (int t = 0; t < 120; t++) {
            int entranceCustomer = Utils.intRandom(2);
            for (int i = 0; i < entranceCustomer; i++) {
                Observer.addBuyer();
                Buyer buyer = new Buyer(Observer.getAllBuyers());
                customers.add(buyer);
                buyer.start();
            }
            Utils.sleep(1_000);
            //update data every 5 seconds
            if (t % 10 == 0) {
                System.out.println("===========================");
                System.out.println("TIME PASSED: " + t);
                System.out.println("CURRENT NUMBER OF CUSTOMERS: " + Observer.countCurrentBuyers());
                System.out.println("===========================");
            }
        }
        for (Buyer buyer : customers) {
            buyer.join();
        }
        System.out.println("Market is closed!");
        System.out.println("Total number of customers: " + Observer.getAllBuyers());
    }
}
