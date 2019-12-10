package by.it.kazak.jd02_03;


import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("------------shop is opened---------------");
        Counter.executorService.execute(new Cashier());
        int numberBuyer = 0;
        int time = 0;

        while (Counter.planComplete()) {
            if (time < 30) {
                int count = Helper.random();
                if (!(Counter.getBuyerInMarket() >= time + 10)) {
                    for (int n = 0; n < count; n++) {
                        if (Counter.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();
                            buyers.add(buyer);
                        }
                    }
                }
                time++;

            } else  {
                int count = Helper.random();
                if (Counter.getBuyerInMarket() <= 40 + (30 - time)) {
                    for (int n = 0; n < count; n++) {
                        if (Counter.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();
                            buyers.add(buyer);
                        }
                    }
                }
                time++;
            }
            if(time== Counter.MINUTE)time=0;
            Helper.sleepThread(1000);
        }


        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Counter.executorShutDown();

        System.out.printf(" TOTAL AMOUNT : %.2f \n",Counter.SUM);
        System.out.println("------------shop is closed-------------");
    }
}
