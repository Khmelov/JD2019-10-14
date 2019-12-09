package by.it.sermyazhko.jd02_01;

import java.util.*;

public class Market {
    //класс Goods можно и не делать , можно было здесь завести переменную, но так логика больше разделена и все ясно
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        Map<String,Integer> product = new HashMap<String,Integer>();
        for (int i = 100; i > 1; i--) {
            product.put(String.format("GOODS%d",i),i*3+17);
        }
        Goods.goods = product;
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
