package by.it.akhmelev.jd02_03;

public class Cashier implements Runnable{
    private String name;

    public Cashier(int number) {
        this.name = "Cashier №"+number;
    }

    @Override
    public void run() {
        System.out.println(this+" opened");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = QueueBuyer.poll();
            if (buyer!=null){
                System.out.println(this+" start service for "+buyer);
                Helper.sleep(Helper.random(2000,5000));
                synchronized (buyer){
                    buyer.setWaitFlag(false);
                    buyer.notifyAll();
                    System.out.println(this+" stop service for "+buyer);
                    System.out.flush();
                }
            }
            else {
                Helper.sleep(1); //:'-(
            }
        }
        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return "-- "+name;
    }
}
