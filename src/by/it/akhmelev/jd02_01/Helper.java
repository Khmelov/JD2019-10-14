package by.it.akhmelev.jd02_01;

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
            Thread.sleep(timeout/Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interupt");
        }
    }


}
