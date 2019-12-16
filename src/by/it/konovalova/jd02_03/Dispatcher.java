package by.it.konovalova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private volatile static AtomicInteger counterBuyer = new AtomicInteger(0);
    private volatile static AtomicInteger countCompleteBuyer = new AtomicInteger(0);
    static int acceleration = 1000;
    private static final int PLAN = 100;

   static void buyerInMarket() {
       counterBuyer.getAndIncrement();
   }

   static void buyerLeaveMarket() {
       counterBuyer.getAndDecrement();
       countCompleteBuyer.getAndIncrement();
   }

   static boolean marketOpened(){
       return counterBuyer.get()+countCompleteBuyer.get()<PLAN;
   }

   static boolean marketClosed(){
       return countCompleteBuyer.get()==PLAN;
   }
}
