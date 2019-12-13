package by.it.kharitonenko.jd02_03.Utils;

import by.it.kharitonenko.jd02_03.Buyer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BuyerQueue {
    private final static BlockingDeque<Buyer> buyerQueue = new LinkedBlockingDeque<>(30);

    public static void add(Buyer buyer) {
        try {
            buyerQueue.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Buyer extract() {
        try {
            return buyerQueue.pollFirst(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getQueueSize() {
            return buyerQueue.size();
    }
}
