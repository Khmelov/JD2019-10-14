package by.it.bodukhin.jd02_01;

import java.util.*;

public class Market {
    public static Map<String, Double> goods = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<Buyer> buyerList = new ArrayList<>();


        goods.put("milk", 1.0);
        goods.put("bread", 1.25);
        goods.put("sprite", 1.5);
        goods.put("beer", 2.0);

        System.out.println("Market opened");
        int time = 0;
        for (int i = 0; i < 120; i++) {
            if(time==60){
                time = 0;
            }
            int currentCount = Helper.random(2);
            if(time<=30) {
                if(!(Dispatcher.countBuyer >= time + 10)) {
                    for (int j = 0; j <= currentCount; j++) {
                        Buyer buyer = new Buyer(++Dispatcher.countBuyer);
                        buyerList.add(buyer);
                        buyer.start();
                        time++;
                    }
                }
                Helper.sleep(1000);
            } else {
                if(Dispatcher.countBuyer <= 40 + (30 - time)){
                    for (int j = 0; j <= currentCount; j++) {
                        Buyer buyer = new Buyer(++Dispatcher.countBuyer);
                        buyerList.add(buyer);
                        buyer.start();
                        time++;
                    }
                }
                Helper.sleep(1000);
            }
        }
        for(Buyer buyer : buyerList){
            buyer.join();
        }
        System.out.println("Market closed");
    }
}
