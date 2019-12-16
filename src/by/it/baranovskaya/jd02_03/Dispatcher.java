package by.it.baranovskaya.jd02_03;

public class Dispatcher {
    static int kSpeed=5000;
    private static final int PLAN=100;
    private volatile static int countBuyer =0;
    private volatile static int countCompleteBuyer=0;

    static synchronized void buyerInMarket(){
        countBuyer++;
    }

    static synchronized void buyerLeaveMarket(){
        countBuyer--;
        countCompleteBuyer++;
    }

    static synchronized boolean marketOpened(){
        return countBuyer+countCompleteBuyer<PLAN;
    }

    static boolean marketClosed(){
        return countCompleteBuyer==PLAN;
    }

}
