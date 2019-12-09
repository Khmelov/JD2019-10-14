package by.it.kazak.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyer {

    private QueueBuyer() {
    }

    private static final Deque<Buyer> buyersDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        buyersDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return buyersDeque.pollFirst();
    }

    static synchronized int getSize() {
        return buyersDeque.size();
    }

}
