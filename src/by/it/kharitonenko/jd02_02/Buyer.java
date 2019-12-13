package by.it.kharitonenko.jd02_02;

import by.it.kharitonenko.jd02_02.Interfaces.IBuyer;
import by.it.kharitonenko.jd02_02.Interfaces.IUseBasket;
import by.it.kharitonenko.jd02_02.Utils.BuyerQueue;
import by.it.kharitonenko.jd02_02.Utils.Observer;
import by.it.kharitonenko.jd02_02.Utils.Utils;

import java.util.Random;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private final boolean PENSIONER;
    private double customerSpeed; //higher number == slower
    private String customerName;
    private Basket basket;
    private int currentMoney;
    private int cheque;

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        enterQueue();
        goOut();
    }

    Buyer(int number) {
        Observer.buyerEntered();
        StringBuilder nameGenerator = new StringBuilder();
        int age = new Random().nextInt(4) + 1;
        basket = new Basket();
        customerSpeed = 1;
        currentMoney = Utils.intRandom(4, 10); //starting money
        if (age == 4) {
            this.PENSIONER = true;
            customerSpeed = 1.5;
            nameGenerator.append("+"); //marks pensioner customer
        } else {
            this.PENSIONER = false;
        }
        nameGenerator.append("Buyer# ").append(number);
        customerName = nameGenerator.toString();

    }

    public void enterQueue() {
        System.out.println(this + " in queue.");
        BuyerQueue.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Unexpected error.");
            }
        }
        System.out.println(this + " finished with cashier.");
    }

    @Override
    public String toString() {
        return this.customerName;
    }

    @Override
    public void enterToMarket() {
        System.out.println(customerName + " entered the market. $" + currentMoney + " in wallet.");
    }

    @Override
    public void chooseGoods() {
        takeBasket();
        putGoodsToBasket();
        sleep();
    }

    @Override
    public void goOut() {
        System.out.println(customerName + " left the market. $" + currentMoney + " left.");
        Observer.buyerLeft();
    }

    @Override
    public void takeBasket() {
        System.out.println(customerName + " took the basket.");
        sleep();
    }

    /**
     * Puts product into the basket.
     * Value <b>result</b> is amount of money customer will spend on chosen product.
     * It equals to -1 if customer can't decide (for example, if there is no money).
     * There is also <b>tries</b> value, it shows how many times customer will try
     * to pick something before leaving the marketplace. Since the most expensive item is $4
     * and the minimum amount of money customer gets is also $4, there will always be at least
     * one item in the basket.
     * <b>Tries</b> value can be changed in <b>Utils</b> class.
     */
    @Override
    public void putGoodsToBasket() {
        int tries = Utils.getTRIES();
        do {
            int result = basket.buySomething(Utils.pickRandomProduct(), currentMoney);
            tries--;
            if (result > 0) {
                cheque += result;
                currentMoney -= result;
            }
        } while (basket.getCapacity() > 0 && tries > 0);
        sleep();
    }

    private void sleep() {
        Utils.sleep(Utils.intRandom(500, 2_000) * customerSpeed);
    }

    public int getCheque() {
        return cheque;
    }

    public Basket getBasket() {
        return basket;
    }
}
