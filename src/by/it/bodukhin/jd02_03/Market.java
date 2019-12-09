package by.it.bodukhin.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Thread> buyerList = new ArrayList<>();
        new Dispatcher().start();
        while (Dispatcher.countBuyer.get() < Dispatcher.PLAN) {
            int currentCount = Helper.random(2);
                for (int j = 0; j <= currentCount; j++) {
                    if (Dispatcher.countBuyer.get() == Dispatcher.PLAN) {
                        break;
                    }
                    Buyer buyer = new Buyer(Dispatcher.countBuyer.incrementAndGet());
                    buyerList.add(buyer);
                    buyer.start();
                }
            Helper.sleep(1000);
        }
        for(Thread buyer : buyerList){
            buyer.join();
        }
        System.out.println("Market closed");
    }
}

