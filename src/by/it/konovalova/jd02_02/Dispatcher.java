package by.it.konovalova.jd02_02;

class Dispatcher {

    static int acceleration=1000;
    private static final int PLAN=100;
    private volatile static int counterBuyer=0;
    private volatile static int countCompleteBuyer=0;

    static synchronized void buyerInMarket(){
        counterBuyer++;
    }

    static synchronized void buyerLeaveMarket(){
        counterBuyer--;
        countCompleteBuyer++;
    }

    static synchronized boolean marketOpened(){
        return counterBuyer+countCompleteBuyer<PLAN;
    }

    static boolean marketClosed(){
        return countCompleteBuyer==PLAN;
    }
/*

    static synchronized void buyerInMarket() {
       counterBuyer++;
   }

   static synchronized void buyerLeaveMarket() {
       counterBuyer--;
       countCompleteBuyer++;
   }

   static synchronized boolean marketOpened(){
       return counterBuyer+countCompleteBuyer<PLAN;
   }

   static boolean marketClosed(){
       return countCompleteBuyer==PLAN;
   }*/
}
