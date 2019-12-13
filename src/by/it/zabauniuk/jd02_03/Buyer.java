package by.it.zabauniuk.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Map<String, Double> basket = null;
    private Semaphore sem;

    public Buyer(int number, Semaphore semaphore) {
        super("Buyer " + number);
        sem = semaphore;
        Dispetcher.buyerInMarket();
    }

    Map<String, Double> getBasket() {
        return basket;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("---> Enter to market " + this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void chooseGoods() {
        takeBacket();
        try {
            sem.acquire();
            System.out.println("started to choose goods " + this);
            putGoodsToBacket();
            System.out.println("end to choose goods " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }


    }

    @Override
    public void goOut() {
        System.out.println("<--- leave the market " + this);
        Dispetcher.buyerLeaveMarket();
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " added to Queue");
        BuyersQueue.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " leave CashBack");
    }

    @Override
    public void takeBacket() {
        basket = new HashMap<>(4);
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " takes a basket");
    }

    @Override
    public void putGoodsToBacket() {
        int cntGoods = Util.random(1, 4);
        if (basket == null)
            System.out.println(this + " doesn't have a basket");
        else {
            for (int i = 1; i <= cntGoods; i++) {
                int timeout = Util.random(100, 200);
                Util.sleep(timeout);
                Map.Entry<String, Double> e = Market.getRandomGoods();
                if (e != null) {
                    basket.put(e.getKey(), e.getValue());
                    System.out.println(this + " puts " + e.getKey() + " - " + e.getValue() + " BYN  to basket.");
                }
            }
        }

    }
}
