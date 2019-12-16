package by.it.yurtsevich.jd02_01;


import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBucket {
    private Map<String, Double> bucket = null;
    private boolean pensioneer = false;

    Buyer(int num) {

        super("Покупатель № " + num + " ");
        Dispacther.buyerInMarket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
        //Util.sleep(3000);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "начал выбирать товары");

        int timeout;
        if (pensioneer) {
            yield();
            timeout = Util.random(1500, 3000);
        } else {
            timeout = Util.random(2000);
        }
        Util.sleep(timeout);
        putGoodsToBacket();
        System.out.println(this + "выбрал товары");

    }


    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispacther.buyerLeftMarket();
    }


    void setPensioneer() {
        this.pensioneer = true;
    }

    @Override
    public void takeBacket()  {
    int timeout;
    bucket = new HashMap<>(4);
    if (pensioneer) {
        timeout = Util.random(150, 300);
    } else {
        timeout = Util.random(100, 200);
    }
    Util.sleep(timeout);
    System.out.println(this + "взял корзину");
}

    @Override
    public void putGoodsToBacket() {
        int countGoods = Util.random(1, 4);
        for (int i = 1; i <= countGoods; i++) {
            int timeout;
            if (pensioneer) {
                timeout = Util.random(150, 300);
            } else {
                timeout = Util.random(100, 200);
            }
            Util.sleep(timeout);
            Map.Entry<String, Double> entry = Market.takeGoods();
            if (entry != null) {
                bucket.put(entry.getKey(), entry.getValue());
                System.out.println(this + "кладет " + entry.getKey() + " стоимостью " + entry.getValue() + " BYN в корзину.");
            }


        }
    }
}