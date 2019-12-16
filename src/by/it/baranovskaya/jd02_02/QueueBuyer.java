package by.it.baranovskaya.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyer {

    private final static Deque<Buyer> queue = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (queue) {
            queue.addLast(buyer);
        }
    }

    static Buyer poll() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }
}
