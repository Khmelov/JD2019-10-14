package by.it.sermyazhko.jd02_03;

import java.util.Map;
import java.util.Random;

class Helper {

    private static Random generator=new Random(System.nanoTime());

    static int random(int max){
        return random(0,max);
    }

    static int random(int start, int end){
        return start+generator.nextInt(end-start);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interrupt");
        }
    }

    //генерирует случайный товар из магазина
    static Map.Entry<String,Integer> randomGoods (Map<String,Integer> map){
        int random = random(0, map.size() - 1);
        int count = 0;
        for (Map.Entry<String,Integer> element : map.entrySet()) {
            if(random==count) return element;
            count++;
        }
        return null;
    }

}
