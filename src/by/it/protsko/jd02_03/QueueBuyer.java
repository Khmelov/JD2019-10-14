package by.it.protsko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class QueueBuyer {
    private final static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void addBuyer(Buyer buyer) {
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static Buyer pollBuyer() {
        try {
            return queue.pollFirst(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int getQueueSize() {
        return queue.size();
    }
}
