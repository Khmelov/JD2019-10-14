package by.it.zabauniuk.jd02_02;

public class Cashier implements Runnable {
    private String name;

    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {

        Dispetcher.cashierList.add(this);
        System.out.println(this + " Cashier started ");


        while (Dispetcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.callFromQueue();
            if (buyer != null) {
                System.out.println(this + " started to work " + buyer);
                int serviceTime = Util.randomFromTo(2000, 5000);
                try {
                    Util.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(buyer + " buy " + buyer.getBasket());
                System.out.println(this + " finished serving " + buyer);
                synchronized (buyer) {
                    buyer.notifyAll();
                }
            } else {
                synchronized (this) {
                    try {
                        this.wait(1000 / Dispetcher.timeFactor);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        System.out.println(this + " finished work");
    }

    @Override
    public String toString() {
        return this.name;
    }

}