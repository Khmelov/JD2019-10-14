package by.it.akhmelev.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();
        for (int t = 0; t < 120; t++) {
            int currentCount = Helper.random(2);
            for (int i = 0; i <= currentCount; i++) {
                Buyer buyer = new Buyer(++Dispatcher.countBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyerList) {
            buyer.join();
        }
        System.out.println("Market closed");
    }

}
