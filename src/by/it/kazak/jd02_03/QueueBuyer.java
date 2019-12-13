package by.it.kazak.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyer {

    private QueueBuyer(){}

    private static final BlockingDeque<Buyer> BUYERS_QUEUE = new LinkedBlockingDeque<>(30);


    static  void add(Buyer buyer) {
        if(buyer.isPensionner())
            BUYERS_QUEUE.addFirst(buyer);
        BUYERS_QUEUE.addLast(buyer);
        if (Counter.needCashiers()) {
            Counter.executorService.execute(new Cashier());
        }
    }

    static Buyer extract(){
        return BUYERS_QUEUE.pollFirst();
    }

    public static  BlockingDeque<Buyer>  getBuyers() {
        return BUYERS_QUEUE;
    }

    static boolean needService() {
        boolean needService;
        needService = (QueueBuyer.getBuyers().size() > 0);
        return needService;
    }
}
