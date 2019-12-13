package by.it.zabauniuk.jd02_03;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Market {
    private static Map<String, Double> goodsList = new HashMap<>(20);

    static Map.Entry<String, Double> getRandomGoods() {
        goodsList.putIfAbsent("milk", 1.5);
        goodsList.putIfAbsent("bread", 1.2);
        goodsList.putIfAbsent("salmon", 1.7);
        goodsList.putIfAbsent("juice", 1.8);
        goodsList.putIfAbsent("lemon", 1.21);
        goodsList.putIfAbsent("potato", 0.35);
        goodsList.putIfAbsent("cucumber", 0.45);
        Set<Map.Entry<String, Double>> entries = goodsList.entrySet();
        Iterator<Map.Entry<String, Double>> itr = entries.iterator();
        int number = Util.random(1, goodsList.size());
        int i = 0;
        while (itr.hasNext()) {
            i++;
            if (i==number)
                return  itr.next();
            else itr.next();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Market opened");
        int numberOfCashiers = 2;


        ExecutorService nwThreadPool = Executors.newFixedThreadPool(5);
        for(int i=1; i<=numberOfCashiers; i++) {
            Cashier cashier = new Cashier(i);
            nwThreadPool.execute(cashier);
        }
        List<Thread> threadList = new ArrayList<>(200);
        /*
        for (int i = 1; i <= numberOfCashiers ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threadList.add(thread);
            thread.start();
        }*/
        int numberBuyer = 0;
        Semaphore sem = new Semaphore(20);
        while (Dispetcher.planComplete()){
            int countBuyer = Util.random(50);
            for (int i=0; i < countBuyer; i++) {
                if (Dispetcher.planComplete()) {
                    Buyer b = new Buyer(++numberBuyer, sem);
                    threadList.add(b);
                    b.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread b: threadList)
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        nwThreadPool.shutdown();
        while (!nwThreadPool.isTerminated()) {
            Thread.yield();
        }
        System.out.println("Market closed");
    }
}