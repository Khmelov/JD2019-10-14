package by.it.volchek.jd02_01;

class Buyer extends Thread implements IBuyer,IUseBacket{

    Buyer(int number) {
        super("Buyer №"+number);
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
        System.out.println(this+" started to choose goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this+" finished to choose goods");
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
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this+" took a backet");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        Backet.backetPut(this.toString());
    }
}
