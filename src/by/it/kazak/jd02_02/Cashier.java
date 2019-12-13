package by.it.kazak.jd02_02;


import java.util.Map;
import java.util.Set;

public class Cashier implements Runnable {
    private int number;

    Cashier(int number) {
        this.number = number;
        Counter.newCashier();
    }

    @Override
    public void run() {
        while (Counter.marketOpened()) {
            Buyer buyer;
            if (QueuePensionner.getSize() > 0) {
                buyer = QueuePensionner.extract();
            } else {
                buyer = QueueBuyer.extract();
            }
            if (buyer != null) {
                service(buyer);
            }
        }
        System.out.println(this + " closed");
        Counter.deleteCashier();

    }

    private void service(Buyer buyer) {
        double totalPrise = 0;
        StringBuilder check = new StringBuilder();
        check.append(this).append(" started service ").append(buyer).append("\n ");
        int timeOut = Helper.random(2000, 5000);
        Helper.sleepThread(timeOut);
        Set<Map.Entry<String, Double>> goods = buyer.basket.entrySet();
        for (Map.Entry<String, Double> next : goods) {
            Double value = next.getValue();
            String good = next.getKey();
            check.append(buyer).append(" buy: ").append(good).append(" ").append(value).append("\n ");
            totalPrise += value;
        }
        check.append(this).append(" finished service ").append(buyer).append("\n ");
        check.append(" total prise:  ").append(totalPrise).append("\n");
        printCheck(check);

        synchronized (buyer.getMonitor()) {
            buyer.getMonitor().notify();
        }
    }

    private void printCheck(StringBuilder check) {
        System.out.println(check);
    }

    @Override
    public String toString() {
        return "----Cashier №" + number;
    }
}
