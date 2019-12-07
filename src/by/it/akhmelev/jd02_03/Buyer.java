package by.it.akhmelev.jd02_03;

class Buyer extends Thread implements IBuyer {

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
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " come to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
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
    public String toString() {
        return getName();
    }
}
