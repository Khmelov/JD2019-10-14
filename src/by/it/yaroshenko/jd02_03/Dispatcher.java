package by.it.yaroshenko.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static int kspeed=1000;

    private static final int PLAN=100;
    private final static AtomicInteger buyerCount=new AtomicInteger(0);
    private final static AtomicInteger countCompleteBuyer=new AtomicInteger(0);

    static void addBuyerInMarket() {
        buyerCount.getAndIncrement();
    }

    static  void buyerLeaveMarket() {
        buyerCount.getAndDecrement();
        countCompleteBuyer.getAndIncrement();
    }

    static synchronized boolean marketIsOpened() {
        return buyerCount.get()+countCompleteBuyer.get()<PLAN;
    }

   static boolean marketIsCloseed() {
        return countCompleteBuyer.get()==PLAN;
    }

    static Map<String, String> mapGoods = new HashMap<>();
    public static void setGoods() {
        mapGoods.put("Milk", "2");
        mapGoods.put("Bread", "1");
        mapGoods.put("Wine", "22");
        mapGoods.put("Nuts", "4");
        mapGoods.put("Orange", "1");
        mapGoods.put("Cokao", "3");
        mapGoods.put("Mango", "2");
        mapGoods.put("PineApple", "4");
        mapGoods.put("Oil", "3");
        mapGoods.put("Water", "0.5");
        mapGoods.put("Beer", "1.5");
        mapGoods.put("Chokolate", "0.7");
        mapGoods.put("Icecream", "1");
        mapGoods.put("Coca-cola", "1");
        mapGoods.put("Sprite", "1");
        mapGoods.put("Beef", "5");
    }

    public static Map<String, String> getMapGoods() {
        return mapGoods;
    }

}
