package by.it.kharitonenko.jd02_03.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Observer {
    //this variable counts ALL buyers
    static final AtomicInteger allBuyers = new AtomicInteger(0);
    //this one counts only CURRENT buyers
    static final AtomicInteger numberOfBuyers = new AtomicInteger(0);
    //choosing goods currently
    static final AtomicInteger choosingGoodsNumber = new AtomicInteger(0);
    //allowed customers count
    static int birthControl = 1;
    //all money market earned
    static int marketMoney = 0;

    public static synchronized void startedChoosing() {
        choosingGoodsNumber.getAndIncrement();
    }

    public static synchronized void stoppedChoosing() {
        choosingGoodsNumber.getAndDecrement();
    }

    public static synchronized int getChoosingGoodsNumber() {
        return choosingGoodsNumber.get();
    }

    public static synchronized void buyerEntered() {
        numberOfBuyers.getAndIncrement();
    }

    public static synchronized void buyerLeft() {
        numberOfBuyers.getAndDecrement();
        allBuyers.getAndIncrement();
    }

    //check for work conditions
    public static synchronized boolean marketOpened() {
        return numberOfBuyers.get() + allBuyers.get() < Utils.MAX_ALLOWED;
    }

    public static boolean marketClosed() {
        return allBuyers.get() >= Utils.MAX_ALLOWED;
    }

    public static int countCurrentBuyers() {
        return numberOfBuyers.get();
    }

    public static synchronized int getBirthControlA() {
        if (Utils.MAX_ALLOWED - allBuyers.get() < 3) {
            return Utils.MAX_ALLOWED - allBuyers.get();
        }
        if (allBuyers.get() > Utils.MAX_ALLOWED) {
            return 0;
        }
        return Utils.intRandom(2);
    }

//    public static int getBirthControl(int time) {
//        if (time / 60 > 0) {
//            time -= 60;
//        }
//        if (getAllBuyers() > Utils.MAX_ALLOWED) {
//            return 0;
//        }
//        int allowedNumber = birthControl;
//        if (numberOfBuyers > 30) {
//            birthControl = allowedNumber - Utils.intRandom(4);
//        }
//        if (time < 30) {
//            if (numberOfBuyers < time + 10 || allowedNumber < 20) allowedNumber += Utils.intRandom(2);
//        } else {
//            if (numberOfBuyers > 40 + (30 - time)) {
//                birthControl--;
//                return 0;
//            }
//        }
//        birthControl = allowedNumber;
//        return birthControl;
//    }

    public static int getAllBuyers() {
        return allBuyers.get();
    }
}
