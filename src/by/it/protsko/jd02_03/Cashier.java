package by.it.protsko.jd02_03;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened cashbox.");

        while (!Dispather.marketClosed()) {
            Buyer buyer = QueueBuyer.pollBuyer();
            if (buyer != null) {
                System.out.println(this + " start service for " + buyer.getName() + "  (buyer goods " + Buyer.showGoodsInBracket(buyer) + ")");
                try {
                    Thread.sleep(Helper.randomValue(2000, 5000) / Dispather.speedProcess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (buyer) {
                    buyer.setWaitFlag(false);
                    buyer.notifyAll();
                    System.out.println(this + " stop service for " + buyer.getName() + ". Сheck amount =" + Buyer.getGoodsCost(buyer) + " BYN");
                    System.out.flush();
                }
            } else {
                try {
                    Thread.sleep(1 / Dispather.speedProcess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + " closed cashbox.");
    }

    @Override
    public String toString() {
        return name;
    }
}
