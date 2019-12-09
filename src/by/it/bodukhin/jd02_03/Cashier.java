package by.it.bodukhin.jd02_03;

public class Cashier implements Runnable{

    private StringBuilder check = new StringBuilder();

    private String name;

    public Cashier(int number){
        name="Cashier # "+number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this+" cashier open");
        Buyer b;
        while ((b= QueueBuyer.extractBuyer())!=null) {
            System.out.println(this + " service " + b);
            Helper.sleep(Helper.random(2000, 5000));
            check.append(b).append(" bought ").append(String.join(", ",b.goodsInBacket))
                    .append("\n").append(b).append(" total price ")
                    .append(b.getTotalPrice()).append("$")
                    .append("\n").append(this).append(" finished service for ")
                    .append(b).append("\n");
            try {
                Dispatcher.semPrintToConsole.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(check);
            Dispatcher.semPrintToConsole.release();
            synchronized (b) {
                b.notify();
            }
        }
        System.out.println(this+" cashier closed");
        Dispatcher.numberOfCashier.getAndDecrement();
    }
}
