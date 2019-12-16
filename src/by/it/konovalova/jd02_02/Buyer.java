package by.it.konovalova.jd02_02;


class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.buyerInMarket();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        for (int i = 0; i < Helper.randomPurchase(4); i++) {
            chooseGoods();
            putGoodsToBacket();
        }
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
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " take backet");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " put goods to backet - "+ Helper.randomMap(Goods.goods).getKey());
    }
    @Override
    public void goToQueue() {
        QueueBuyer.add(this);
     //   System.out.println("пошли на кассу");
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("What???");
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the market");
    }

    @Override
    public String toString() {
        return getName();
    }
}
