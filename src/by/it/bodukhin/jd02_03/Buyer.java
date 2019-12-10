package by.it.bodukhin.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {

    List<String> goodsInBacket = new ArrayList<>();

    Semaphore sem = new Semaphore(20);

    private boolean pensioneer = false;

    public Buyer(int number) {
        super("Buyer #"+ number);
        if(number % 4 == 0) this.pensioneer=true;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        getToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" come to market");

    }

    @Override
    public void chooseGoods() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this+" started to choosed goods");
        if(pensioneer) Helper.sleep(Helper.random(750, 3000));
        int timeout = Helper.random(500,2000);
        Helper.sleep(timeout);

    }

    @Override
    public void getToQueue() {
        QueueBuyer.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+" service finished");
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the market");
        Dispatcher.countCompeteBuyers.getAndIncrement();

    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this+" took backet");
    }

    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice=totalPrice;
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this+" finished to choosed goods");
        sem.release();
        double price = 0;
        int countOfGoods = Helper.random(1, 4);
        int timeToPut = Helper.random(500, 2000);
        if(pensioneer) timeToPut = Helper.random(750,3000);
        for (int i = 0; i <countOfGoods ; i++) {
            Good good = Goods.getRandomGood();
            goodsInBacket.add(good+" for " + good.getPrice()+"$");
            price+=good.getPrice();
            System.out.println(this + " put to the basket " + good);
            Helper.sleep(timeToPut);
        }
        setTotalPrice(price);
    }
}
