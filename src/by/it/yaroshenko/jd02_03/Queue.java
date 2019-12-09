package by.it.yaroshenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {
    private final static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
            try {
                queue.putLast(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
