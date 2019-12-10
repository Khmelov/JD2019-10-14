package by.it.bodukhin.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class  QueueBuyer {

    private final static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer){
        try {
            queue.putLast(buyer);
            System.out.println(buyer+" entered to queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Buyer extractBuyer() {
        try {
            return queue.pollFirst(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int getCount(){
            return queue.size();
    }
}
