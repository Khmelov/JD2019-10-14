package by.it.sermyazhko.jd02_02;

class Dispatcher {
    static int kSpeed=1000;

    private static final int PLAN=100;
    private volatile static int countBuyer=0;
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
