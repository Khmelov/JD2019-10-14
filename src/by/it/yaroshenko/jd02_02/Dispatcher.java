package by.it.yaroshenko.jd02_02;

import java.util.*;

public class Dispatcher {
    static int kspeed=1000;

    private static final int PLAN=100;
    private volatile static int buyerCount=0;
    private volatile static int countCompleteBuyer=0;

    static synchronized void addBuyerInMarket() {
        buyerCount++;
    }

    static synchronized void buyerLeaveMarket() {
        buyerCount--;
        countCompleteBuyer++;
    }

    static synchronized boolean marketIsOpened() {
        return buyerCount+countCompleteBuyer<PLAN;
    }

   static boolean marketIsCloseed() {
        return countCompleteBuyer==PLAN;
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
