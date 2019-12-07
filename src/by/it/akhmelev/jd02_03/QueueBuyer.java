package by.it.akhmelev.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class QueueBuyer {

    private final static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer poll() {
        try {
            return queue.pollFirst(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
