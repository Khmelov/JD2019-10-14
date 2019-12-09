package by.it.sermyazhko.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket{


    Buyer(int number) {
        super("Buyer №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int currentCount = Helper.random(1,4);
        for (int i = 0; i < currentCount; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this +" come to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started to choose goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        //System.out.println(this +" finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the market");
    }

    @Override
    public void takeBacket() {
        System.out.println(this +" takes a basket");//нужно ли время на взятие корзины??
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
    }

    @Override
    public void putGoodsToBacket() {
        //Helper.randomGoods(Goods.goods);
        System.out.println(this +" put the "+ Helper.randomGoods(Goods.goods).getKey()+" in the basket");
        int timeout = Helper.random(500,2000);
        Helper.sleep(timeout);
    }

    @Override
    public String toString() {
        return getName();
    }
}
