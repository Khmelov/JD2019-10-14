package by.it.bodukhin.jd02_02;

import java.util.ArrayDeque;

public class  QueueBuyer {

    private static final ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void add(Buyer buyer){
        synchronized (queue){
            queue.addLast(buyer);
        }
    }

    static Buyer extractBuyer(){
        synchronized (queue){
            return queue.pollFirst();
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }
}
