package by.it.yurtsevich.jd02_01;

import java.util.Random;

public class Helper {

    private static Random generator=new Random((System.nanoTime()));

    static int random(int max) {
        return random(0,max);
    }

    static int random(int start, int end){
        return start+generator.nextInt(end-start);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispacther.kSpeed);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interupt");
        }
    }
    }
