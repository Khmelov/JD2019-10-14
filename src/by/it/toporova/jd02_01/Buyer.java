package by.it.toporova.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = new Basket();
    private boolean retired = false;//пенсионер

    Buyer(int number) {
        super("buyer №" + number);
        Dispatcher.totalBuyersCount++;
        Dispatcher.buyersCount++;
        if (Dispatcher.totalBuyersCount%4 == 0) {//выполняем условие, что каждый 4 - пенсионер
            this.retired = true;
            Dispatcher.totalRetiredCount++;
            this.setName(this.getName() + "(retired)");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int goodsQuantity = Helper.getRandom(1, 4);//набор рандомного количества товаров от 1 до 4
        for (int i = 0; i < goodsQuantity; i++) {//набираем количество определенных товаров
            chooseGoods();
            putGoodsToBasket();
        }
        goOut();
        Dispatcher.buyersCount--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered the market");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        int timeout = Helper.getRandom(500, 2000); //время на каждую операцию от 0.5 до 2 секунд
        System.out.println(this.getName() + " is choosing " + timeout);
        Helper.sleep(retired ? (int) (timeout * 1.5) : timeout); //если клиент - пенсионер, то работы удлиняются в 1.5 раза.
        System.out.flush();//гасим
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " exited the market");
        System.out.flush();
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " took basket");
        int timeToTakeBasket = Helper.getRandom(100, 200);
        Helper.sleep(retired ? (int) (timeToTakeBasket * 1.5) : timeToTakeBasket);
        System.out.flush();
    }

    @Override
    public void putGoodsToBasket() {
        String goods = Helper.getRandomGoods();
        System.out.println(this.getName() + " took " + goods);
        System.out.flush();
        int timeToTakeGoods = Helper.getRandom(100, 200);
        Helper.sleep(retired ? (int) (timeToTakeGoods * 1.5) : timeToTakeGoods);
        double price = Goods.priceList.get(goods);
        this.basket.goods.put(goods, price);
    }
}
