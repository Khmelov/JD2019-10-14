package by.it.kazak.jd02_03;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {

    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    static final int K_SPEED = 1000;
    private static final int PLAN = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    static final AtomicInteger cashiersCounter = new AtomicInteger(0);

    static double SUM = 0;


    static final int MINUTE = 60;


    static void newBuyer() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndIncrement();
    }

    static void deleteBuyer() {
        buyerInMarket.getAndDecrement();
    }

    static int getBuyerInMarket() {
        return buyerInMarket.get();
    }

    static boolean planComplete() {
        return buyerCounter.get() != PLAN;
    }


    static boolean needCashiers() {
        boolean res;
        res = (cashiersCounter.get() * 5 < QueueBuyer.getBuyers().size());
        if (!res && cashiersCounter.get() == 1)
            res = Counter.planComplete();
        if (cashiersCounter.get() >= 5)
            res = false;
        return res;
    }


    private static final ConcurrentHashMap<String, Double> LIST_OF_GOODS = new ConcurrentHashMap<String, Double>() {{
        put("Milk", 1.68);
        put("Jam", 3.46);
        put("Broad", 0.70);
        put("Butter", 2.58);
        put("Candy", 2.48);
        put("Orange", 1.45);
        put("Apple", 0.54);
        put("Cheese", 3.04);
        put("Crisp", 2.20);
        put("Porridge", 1.50);

    }};

    static ConcurrentHashMap<String, Double> getListOfGoods() {
        return LIST_OF_GOODS;
    }

    static void executorShutDown() {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Helper.sleepThread(10);
        }
    }


}
