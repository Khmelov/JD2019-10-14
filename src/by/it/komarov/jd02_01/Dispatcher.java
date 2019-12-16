package by.it.komarov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {
    static final Integer fakeMonitor = 0;
    static final int PLAN = 100;
    static volatile int countBuyer = 0;
    static volatile int countCompeteBuyers = 0;
    static int kSpeed = 1000;
    static List<Thread> cashiers = new ArrayList<>();

}

