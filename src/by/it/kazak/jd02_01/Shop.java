package by.it.kazak.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("------------shop is opened---------------");
        List<Thread> buyers = new ArrayList<>();
        int numberBuyer = 0;

        for (int countMinuts = 0; countMinuts < 2; countMinuts++) {
            int time = 0;
            while (time < Counter.MINUTE) {
                if (time <= 30) {
                    int count = Helper.random(2);
                    if (!(Buyer.numberInTheShop >= time + 10)) {
                        for (int n = 0; n < count; n++) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            numberBuyer++;
                            buyer.start();
                            buyers.add(buyer);
                        }
                    }
                    time++;
                    Helper.sleepThread(1000);

                } else {
                    int count = Helper.random(2);
                    if (Buyer.numberInTheShop <= 40 + (30 - time)) {
                        for (int n = 0; n < count; n++) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();
                            numberBuyer++;
                            buyers.add(buyer);
                        }
                    }
                    time++;
                    Helper.sleepThread(1000);
                }
            }
        }

        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------shop is closed-------------");
    }
}
