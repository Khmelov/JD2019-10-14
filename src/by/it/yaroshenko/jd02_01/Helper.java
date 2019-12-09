package by.it.yaroshenko.jd02_01;

import java.util.Random;

public class Helper {
    private static Random generator = new Random(System.nanoTime());

    static int random(int max){
        return random(0,max);
    }
    static int random(int starts, int end){
        return starts+generator.nextInt(end-starts+1);
    }
    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.kspeed);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interrupt");
        }
    }
}
