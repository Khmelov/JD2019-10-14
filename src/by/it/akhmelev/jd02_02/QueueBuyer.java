package by.it.akhmelev.jd02_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
