package by.it.kazak.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueuePensionner {

    private QueuePensionner(){}

    private static final Deque<Buyer> pensionnersQueue = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        pensionnersQueue.addLast(buyer);
    }

    static synchronized Buyer extract(){
        return pensionnersQueue.pollFirst();
    }

    static synchronized int getSize() {
        return pensionnersQueue.size();
    }
}
