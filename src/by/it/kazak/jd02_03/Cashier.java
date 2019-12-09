package by.it.kazak.jd02_03;


import java.util.Map;
import java.util.Set;

public class Cashier implements Runnable {
    private int number;

    Cashier(){
        this.number = Counter.cashiersCounter.incrementAndGet();
    }
    @Override
    public void run() {
        synchronized (System.out) {
            System.out.println(this + " Opened");
            System.out.println("Queue  is: " + QueueBuyer.getBuyers().size());
        }
        while (QueueBuyer.needService()) {
            Buyer buyer = null;
            if (QueueBuyer.getBuyers().size() > 0)
                buyer = QueueBuyer.extract();
            if (buyer != null) {
                service(buyer);
            }
        }
        System.out.println(this + " closed");
        Counter.cashiersCounter.decrementAndGet();
    }

    private void service(Buyer buyer) {
        double totalPrise = 0;
        StringBuilder check = new StringBuilder();
        check.append("====================\n");
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
        Counter.SUM += totalPrise;
        check.append(this).append(" finished service ").append(buyer).append("\n ");
        check.append("====================\n");
        check.append(" total prise:  ").append(totalPrise).append("\n");
        check.append("Queue is: ").append(QueueBuyer.getBuyers().size());
        printCheack(check);

        synchronized (buyer.getMonitor()) {
            buyer.setWait();
            buyer.getMonitor().notify();
        }
        if(!(QueueBuyer.needService()))
            Helper.sleepThread(500);
    }

    private void printCheack(StringBuilder check) {
        System.out.println(check);
    }

    @Override
    public String toString() {
        return "----Cashier №" + number;
    }
}
