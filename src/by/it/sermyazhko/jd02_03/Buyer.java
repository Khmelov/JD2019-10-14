package by.it.sermyazhko.jd02_03;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer {

    private static Semaphore sem = new Semaphore(5);
    public int getAmount() {
        return amount;
    }

    //сумма чека
    private int amount;
    public Map<String, Integer> getGoods() {
        return goods;
    }
    //корзина каждого покупателя
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

        count();
        writeInfo();
        goToQueue();
        goOut();
        Dispatcher.buyerLeaveMarket();

    }

    @Override
    public void writeInfo() {
        System.out.printf("Goods that %s bought: \n", this);
        for (Map.Entry<String, Integer> thing : this.getGoods().entrySet()) {
            System.out.printf("%4s%s, cost - %d\n","-", thing.getKey(), thing.getValue());
        }
        System.out.printf("Total amount of check:%d\n", this.getAmount());
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " come to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");

        for (int i = 0; i < Helper.random(1,4); i++) {
            this.goods.put(String.format("GOODS%d",i),i*3+17);
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
    public void count() {
        for (Map.Entry<String, Integer> thing : this.goods.entrySet()) {
            this.amount+=thing.getValue();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
