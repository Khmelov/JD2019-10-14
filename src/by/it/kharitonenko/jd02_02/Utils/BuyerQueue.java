package by.it.kharitonenko.jd02_02.Utils;

import by.it.kharitonenko.jd02_02.Buyer;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {
    private final static Deque<Buyer> buyerQueue = new LinkedList<>();

    public static void add(Buyer buyer) {
        synchronized (buyerQueue) {
            buyerQueue.add(buyer);
        }
    }

    public static Buyer extract() {
        synchronized (buyerQueue) {
            return buyerQueue.pollFirst();
        }
    }

    public static int getQueueSize() {
            return buyerQueue.size();
    }
}
