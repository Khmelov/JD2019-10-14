package by.it.yurtsevich.jd02_03;

import static by.it.yurtsevich.jd02_03.Dispatcher.marketIsOpened;
import static by.it.yurtsevich.jd02_03.Util.random;
import static by.it.yurtsevich.jd02_03.Util.sleep;

public class Cashier implements Runnable {
    private String name;

    Cashier(int number){
        name="--Cashier "+number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (marketIsOpened()){
        Buyer buyer = QueueBuyers.extract();
        if (buyer !=null){
        System.out.printf("%-9s started processing %s\n",this,buyer);
        int timeout = random(2000, 5000);
        sleep(random(timeout));
        System.out.printf("%-9s finished processing %s\n",this,buyer);
        synchronized (buyer){
            buyer.setWaiting(false);
            buyer.notifyAll();
        }
    }
    else {
        sleep(1);
    }

}
    }
}
