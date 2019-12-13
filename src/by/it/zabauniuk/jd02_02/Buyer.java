package by.it.zabauniuk.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private static Basket basket;

    Basket getBasket() {
        return basket;
    }

    Buyer() {
        int randomNumber = Util.randomFromTo(1, 4);
        this.setName("Buyer №" + Dispetcher.buyerEnter());
        basket = new Basket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(">>> " + this + " go to Market");
    }

    @Override
    public void takeBasket() {
        try {
            int pause = Util.randomFromTo(100, 200);
            Util.sleep(pause);
        } catch (InterruptedException e) {

            System.out.println(this.getName() + ": exception to takeBasket()!");
        }
        System.out.println(this + " take a basket");
    }

    @Override
    public void chooseGoods() {
        try {
            int pause = Util.randomFromTo(500, 2000);
            Util.sleep(pause);
        } catch (InterruptedException e) {

            System.out.println(this.getName() + ": exception chooseGoods()!");
        }
        System.out.println(this + " chose the goods");
    }


    @Override
    public void putGoodsToBasket() {
        try {
            int pause = Util.randomFromTo(100, 200);
            Util.sleep(pause);
        } catch (InterruptedException ex) {
            System.out.println(this.getName() + ": exception putGoodsToBasket()!");
        }

    }

    @Override
    public void goToQueue() {
        BuyersQueue.add(this);
        System.out.println(this + " go to queue");
        for (Cashier cashier : Dispetcher.cashierList) {
            synchronized (cashier) {
                cashier.notify();
            }
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Exception buyer " + this);
            }
        }
        System.out.println(this + " leave to queue ");
    }

    @Override
    public void goOut() {
        Dispetcher.buyerExit();
        System.out.println(this + " leave to Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}