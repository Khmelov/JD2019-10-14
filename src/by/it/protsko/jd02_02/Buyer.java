package by.it.protsko.jd02_02;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner;
    private Map<String, Double> buyerGoods = new HashMap<>();

    Buyer(int number) {
        super("Buyer №" + number);
        Dispather.buyerInMarket();
    }

    Buyer(int number, boolean isPensioner) {
        super("Buyer №" + number + " (pensioner)");
        this.pensioner = isPensioner;
        Dispather.buyerInMarket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispather.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered to market.");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this.getName() + " started choose goods.");
        putGoodsToBasket();
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " taked a basket.");
    }

    @Override
    public void putGoodsToBasket() {
        Map<String, Double> selectedGood;
        int countGoods = Helper.randomValue(1, 4);
        for (int i = 1; i <= countGoods; i++) {
            selectedGood = Goods.randomGood();
            String good = selectedGood.keySet().iterator().next();
            buyerGoods.put(good, buyerGoods.get(good) == null ?
                    selectedGood.get(good) : selectedGood.get(good) + buyerGoods.get(good));
            try {
                if (this.pensioner) {
                    Thread.sleep((Helper.randomValueForPensioner(500, 2000)) / Dispather.speedProcess);
                } else {
                    Thread.sleep((Helper.randomValue(500, 2000)) / Dispather.speedProcess);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " choosed goods." + buyerGoods);
    }

    public synchronized static String showGoodsInBracket(Buyer buyer) {
        return buyer.buyerGoods.toString();
    }

    public static synchronized String getGoodsCost(Buyer buyer) {
        double totalCost = 0;
        for (Double goodCost : buyer.buyerGoods.values()) {
            totalCost += goodCost;
        }

        DecimalFormat df = new DecimalFormat(".2");

        return df.format(totalCost);
    }


    @Override
    public void goOut() {
        System.out.println(this.getName() + " leaved the market.");
    }

    @Override
    public void goToQueue() {
        QueueBuyer.addBuyer(this);
        System.out.println(this.getName() + " come in the queue.");
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " complete service.");
    }
}
