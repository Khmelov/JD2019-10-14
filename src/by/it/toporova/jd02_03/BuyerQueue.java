package by.it.toporova.jd02_03;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class BuyerQueue {
    static ArrayBlockingQueue<Buyer> queue = new ArrayBlockingQueue<>(30); //общая очередь не должна быть больше 30 человек
    private static Queue<Buyer> retiredQueue = new LinkedList<>();

    static void putToQueue(Buyer buyer) {
        if (buyer.retired) retiredQueue.add(buyer); //внеочередное обслуживание
        else {
            try {
                queue.put(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static Buyer pollBuyer() {
        if (retiredQueue.size() > 0) return retiredQueue.poll();
        return queue.poll();
    }
}


