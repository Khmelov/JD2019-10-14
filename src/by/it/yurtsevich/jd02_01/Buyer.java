package by.it.yurtsevich.jd02_01;

class Buyer extends Thread implements IBuyer {

   Buyer (int number){super ("Buyer №" + number );}

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this +"Come to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this +" started to choose goods");
        int timeout=Helper.random(500,2000);
        Helper.sleep(timeout);
    }

    @Override
    public void goOut() {
        System.out.println(this+ "Leave the market");
    }

    @Override
    public String toString() {
        return getName();
    }
}
