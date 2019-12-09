package by.it.toporova.jd02_02;

import java.util.Map;

public class Cashier implements Runnable {
    private String name;
    private int numberOfCashier;

    //конструктор по номеру кассы
    public Cashier(int number) {
        Dispatcher.newCashier();
        this.name = "Cashier №" + number;
        this.numberOfCashier = number;
    }

    @Override
    public void run() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " opened");
        }
        while (!Dispatcher.planIsComplete() && Dispatcher.getBuyersCount() >=
                (Dispatcher.getCountCashiers() - 1) * 5) {
            cashiersWork();
        }
        if (Dispatcher.getCountCashiers() == 1){
            synchronized (Dispatcher.LOCK_ARRAY){
                Dispatcher.LOCK_ARRAY.notify();
            }
        }
        Dispatcher.cashierCloses();
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " closed");
        }
    }

    //касса в рабочем состоянии
    private void cashiersWork() {
        startMoreCashiers();
        Buyer buyer = BuyerQueue.takeOutOfQueue();
        if (buyer != null) {
            cashierServiceBuyer(buyer);

        } else if (Dispatcher.getCountCashiers() <= 1) {
            synchronized (Dispatcher.LOCK_QUEUE) {
                try {
                    Dispatcher.LOCK_QUEUE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //касса обслуживает покупателя
    private void cashierServiceBuyer(Buyer buyer) {
        String s = getShiftForConsole();
        synchronized (Dispatcher.LOCK_CONSOLE) {
            cashiersWorkToConsole(buyer, s);
        }
        int time = Helper.getRandom(2000, 5000);
        Helper.sleep(buyer.retired ? (int) (time * 1.5) : time);
        synchronized (Buyer.getMonitor(buyer)) {
            buyer.notify();
        }
    }

    //метод для вывода работы кассы с определённым покупателем в консоль
    private void cashiersWorkToConsole(Buyer buyer, String s) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSize of queue: " +
                BuyerQueue.getQueueSize());
        System.out.println(s + this + " service " + buyer);
        double price = 0;
        for (Map.Entry<String, Double> entry : buyer.basket.goods.entrySet()) {
            System.out.println(s + buyer + " bought " + entry.getKey() + " for " + entry.getValue());
            price += entry.getValue();
        }
        price = (int) Math.round(price * 10) / 10.0;
        System.out.println(s + buyer + " totally paid = " + price);
        Dispatcher.increaseOverallPrice(price);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tMarket's cashier: " +
                Dispatcher.getOverallPrice());
    }

    private String getShiftForConsole() {
        String s;
        switch (this.numberOfCashier) {
            case 1:
                s = "\t\t\t";
                break;
            case 2:
                s = "\t\t\t\t\t\t";
                break;
            case 3:
                s = "\t\t\t\t\t\t\t\t\t";
                break;
            case 4:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 5:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 6:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 7:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            case 8:
                s = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
                break;
            default:
                s = "";
        }
        return s;
    }

    //метод для проверки нужны ли дополнительные кассы и при необходимости их открытия
    private void startMoreCashiers() {
        if (Dispatcher.getCountCashiers() < 5) {
            while (BuyerQueue.getQueueSize() > Dispatcher.getCountCashiers() * 5) {
                Thread th = new Thread(new Cashier(Dispatcher.cashiersNumber++));
                synchronized (Dispatcher.LOCK_ARRAY) {
                    Market.listOfThreads.add(th);
                }
                th.start();
            }
        }
    }



    @Override
    public String toString() {
        return this.name;
    }
}
