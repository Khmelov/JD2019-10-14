package by.it.kharitonenko.jd02_01.Utils;

import java.util.Random;

/**
 * Different helpful static methods and program options.
 */
public class Utils {
    static final int SPEED = 10;      // global speed, increase this value to speed up the program
    static final int TRIES = 6;      // how many times buyer will check catalogue before leaving
                                     // if he can't decide on what to buy

    public static int getGlobalSpeed() {
        return SPEED;
    }

    public static int getTRIES() {
        return TRIES;
    }

    //random int generators methods
    public static int intRandom(int max) {
        return intRandom(0, max);
    }

    public static int intRandom(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

    //returns random enum (goods)
    public static Goods pickRandomProduct() {
        Goods[] checklist = Goods.values();
        return checklist[intRandom(checklist.length - 1)]; // choose random product
    }

    //thread sleep method
    public static void sleep(double time) {
        try {
            Thread.sleep((long) (time / getGlobalSpeed()));
        } catch (InterruptedException e) {
            System.err.println("Unexpected sleep interruption.");
        }
    }
}