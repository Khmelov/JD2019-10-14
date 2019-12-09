package by.it.kazak.jd02_01;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer = false;
    static Integer numberInTheShop = 0;

    Buyer(int number) {
        super("Buyer № " + number);
        if (number % 4 == 0) {
            this.pensioneer = true;
        }
    }

    @Override
    public void run() {
        numberInTheShop++;
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
        numberInTheShop--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        if (pensioneer) Helper.sleepThread(Helper.random(750, 3000));
        Helper.sleepThread(Helper.random(500, 2000));
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left the store");
    }

    @Override
    public void takeBacket() {
        if (pensioneer) Helper.sleepThread(Helper.random(750, 3000));
        Helper.sleepThread(Helper.random(500, 2000));
        System.out.println(this + " Take basket");
    }

    @Override
    public void putGoodsToBacket() {
        if (pensioneer) Helper.sleepThread(Helper.random(150, 300));
        Helper.sleepThread(Helper.random(100, 200));
        int numberOfGoods = Helper.random(1, 4);

        Map<String, Double> listOfGoods = Counter.getGoods();
        Set<String> keySets = listOfGoods.keySet();

        ArrayList<String> listOfKeys = new ArrayList<>(keySets);

        for (int i = 0; i < numberOfGoods; i++) {
            int indexRandom = Helper.random(0, listOfKeys.size() - 1);
            String chosenGood = listOfKeys.get(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            System.out.println(this + " Chosen: " + chosenGood + " " + prise);
        }
    }

    @Override
    public String toString() {
        if (this.pensioneer) return this.getName() + " pensioneer";
        else return this.getName();
    }
}
