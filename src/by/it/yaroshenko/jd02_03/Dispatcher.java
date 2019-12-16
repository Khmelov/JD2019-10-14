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

}
