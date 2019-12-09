package by.it.bodukhin.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBacket {

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
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" come to market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started to choosed goods");
        if(pensioneer) Helper.sleep(Helper.random(750, 3000));
        int timeout = Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+" finished to choosed goods");

    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the market");

    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this+" took backet");
    }

    @Override
    public void putGoodsToBacket() {
        List<String> nameOfGoods= new ArrayList<>(Market.goods.keySet());
        int countOfGoods = Helper.random(0, 4);
        int timeToPut = Helper.random(500, 2000);
        if(pensioneer) timeToPut = Helper.random(750,3000);
        for (int i = 0; i <countOfGoods ; i++) {
            int whatGood = Helper.random(0,nameOfGoods.size()-1);
            Helper.sleep(timeToPut);
            System.out.println(this+" took to backet "+ nameOfGoods.get(whatGood)
                    + " for "
                    + Market.goods.get(nameOfGoods.get(whatGood)) + "$");
        }
    }
}
