package by.it.sermyazhko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static int kSpeed=1000;

    private static final int PLAN=100;
    private final static AtomicInteger countBuyer=new AtomicInteger(0);
    private final static AtomicInteger countCompleteBuyer=new AtomicInteger(0);

    static void buyerInMarket(){
        countBuyer.getAndIncrement();
    }

    static void buyerLeaveMarket(){
        countBuyer.getAndDecrement();
        countCompleteBuyer.getAndIncrement();
    }

    static boolean marketOpened(){
        return countBuyer.get()+countCompleteBuyer.get()<PLAN;
    }

    static boolean marketClosed(){
        return countCompleteBuyer.get()==PLAN;
    }



}
