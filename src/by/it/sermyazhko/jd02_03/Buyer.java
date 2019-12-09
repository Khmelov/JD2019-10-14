package by.it.sermyazhko.jd02_03;


import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer {

    private static Semaphore sem = new Semaphore(20);

    //сумма чека
    private int amount;
    //корзина из товаров у каждого покупателя
    private Map<String,Integer> goods = new HashMap<>();

    private boolean waitFlag = false;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.buyerInMarket();
    }

    @Override
    public void run() {

        enterToMarket();
        try {
            sem.acquire();
            chooseGoods();
     } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            sem.release();
        }
        goToQueue();
        checkAmount();
        checkInformation();
        goOut();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void checkInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Goods that %s bought: \n", this));
        for (Map.Entry<String, Integer> thing : goods.entrySet()) {
            sb.append(String.format("%4s%s, cost - %d\n","-", thing.getKey(), thing.getValue()));
        }
        sb.append(String.format("Total amount of check:%d", this.amount));
        System.out.println(sb);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " come to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");

        //собираем вещи
        for (int i = 0; i < Helper.random(1,4); i++) {
            this.goods.put(Helper.randomGoods(Goods.products).getKey(), Helper.randomGoods(Goods.products).getValue());
        }

        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToQueue() {
        QueueBuyer.add(this);
        waitFlag = true;
        synchronized (this) {
            try {
                while (waitFlag)
                    this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " leave the market");
    }

    @Override
    public void checkAmount() {
        for (Map.Entry<String, Integer> thing : this.goods.entrySet()) {
            this.amount+=thing.getValue();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
