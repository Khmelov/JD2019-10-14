package by.it.zabauniuk.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyersQueue {

    private static Deque<Buyer> buyersQueue = new LinkedList<>();

    static synchronized void add(Buyer buyer) {
        buyersQueue.addLast(buyer);
    }

    static synchronized Buyer callFromQueue() {
        return buyersQueue.pollFirst();

    }

}