package by.it.yurtsevich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Buyer> buyerList=new ArrayList<>();
        for (int t = 0; t <120 ; t++) {
            int courrentCount=Helper.random( 2);
            for (int i = 0; i <=courrentCount ; i++) {
                Buyer buyer = new Buyer(++Dispacther.countBuyer);
                buyerList.add(buyer);
                buyer.start();

        } Helper.sleep(2000);
    }for (Buyer buyer : buyerList) {
        buyer.join();
    }
        System.out.println("Market closed");
}
}
