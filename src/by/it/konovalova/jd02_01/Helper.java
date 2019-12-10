package by.it.konovalova.jd02_01;

import java.util.Map;
import java.util.Random;

class Helper {

    private static Random generator = new Random(System.nanoTime());

    static int random(int max) {
        return random(0, max);
    }

    static int randomPurchase(int max) {
        return (int)(1+Math.random()*max);
    }

    static int random(int start, int end) {
        return start + generator.nextInt(end - start);
    }

    static Map.Entry<String, Integer> randomMap(Map<String, Integer> goods) {
        int random = random(0, goods.size() - 1);
        int count = 0;
        for (Map.Entry<String, Integer> element : goods.entrySet()) {
            if (random == count) return element;
            count++;
        }
        return null;
    }


    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.acceleration);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interupt");
        }
    }

}
