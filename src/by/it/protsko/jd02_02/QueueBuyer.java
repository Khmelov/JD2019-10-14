package by.it.protsko.jd02_02;

import java.util.ArrayDeque;

public class QueueBuyer {
    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (queue) {
            queue.addLast(buyer);
        }
    }

    static Buyer pollBuyer() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static int getQueueSize(){
        synchronized (queue){
            return queue.size();
        }
    }
}
