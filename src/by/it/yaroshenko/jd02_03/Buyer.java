package by.it.yaroshenko.jd02_03;

import java.util.ArrayList;
import java.util.Random;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitFlag = false;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    public Buyer(int number) {
        super("Buyer #" + number);
        Dispatcher.addBuyerInMarket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        goOut();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " come to market");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " take the basket");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        waitFlag = true;
        while (waitFlag) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void putGoodsToBacket() {
        putGoodsFromOneToFour();
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
    }

    private void putGoodsFromOneToFour() {
        Goods.setGoods();
        int countOfGoods = Helper.random(1, 4);
        for (int i = 1; i <= countOfGoods; i++) {
            Random random = new Random();
            ArrayList<String> keys = new ArrayList<>(Goods.mapGoods.keySet());
            String randomKey = keys.get(random.nextInt(keys.size()));
            String value = Goods.mapGoods.get(randomKey);
            String goods = randomKey + " prise " + value + "$";
            System.out.printf("%s put %s\n", this, goods);
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " leave to market");
    }

    @Override
    public String toString() {
        return getName();
    }
}
