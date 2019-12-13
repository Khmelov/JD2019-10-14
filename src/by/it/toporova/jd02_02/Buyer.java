package by.it.toporova.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    Basket basket = new Basket();
    boolean retired = false;     //поле, помечающее пенсионеров
    private int buyerNumber;     //номер покупателя



    Buyer(int number) {
        super("buyer №" + number);
        this.buyerNumber = number;
        Dispatcher.newBuyer();
        if (Helper.getRandom(1, 4) == 1) {
            this.retired = true;
            this.setName(this.getName() + "(retired)");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Goods goods = new Goods();
        int priceListSize = goods.getPriceListSize();
        int quantity = Helper.getRandom(1, 4);
        for (int i = 0; i < quantity; i++) {
            chooseGoods();
            putGoodsToBasket(goods, priceListSize);
        }
        goToQueue();
        goOut();
        Dispatcher.buyerLeaved(this);
    }

    //метод для кастования buyer'a к object'у
    static Object getMonitor(Buyer buyer) {
        return buyer;
    }

    //геттер для номера покупателя
    int getBuyerNumber() {
        return buyerNumber;
    }

    //покупатель отправляется в очередь
    private void goToQueue() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " went to the queue");
        }
        synchronized (this) {
            try {
                BuyerQueue.putToQueue(this);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " entered the market");
        }
    }

    @Override
    public void chooseGoods() {
        int timeout = Helper.getRandom(500, 2000);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " is choosing goods " + timeout + " mlsec");
        }
        Helper.sleep(retired ? (int) (timeout * 1.5) : timeout);
    }

    @Override
    public void goOut() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " exited the market");
        }
    }

    @Override
    public void takeBasket() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " took basket");
        }
        int timeToTakeBasket = Helper.getRandom(100, 200);
        Helper.sleep(retired ? (int) (timeToTakeBasket * 1.5) : timeToTakeBasket);
    }

    @Override
    public void putGoodsToBasket(Goods list_of_goods, int priceListSize) {
        String goods = Helper.getRandomGoods(priceListSize);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this.getName() + " took " + goods);
        }
        int timeToTakeGoods = Helper.getRandom(100, 200);
        Helper.sleep(retired ? (int) (timeToTakeGoods * 1.5) : timeToTakeGoods);
        double price = list_of_goods.getPrice(goods);
        this.basket.goods.put(goods, price);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}