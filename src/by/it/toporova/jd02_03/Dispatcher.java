package by.it.toporova.jd02_03;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int k_speed = 1000;

    // static int buyersCount;

    static final int K_SPEED = 50;     //коэффициент ускорения программы (для отладки)
    static AtomicInteger cashiersNumber = new AtomicInteger(1);     //нумератор кассиров
    static AtomicInteger cashiersCount = new AtomicInteger(0);     //количество работающих касс
    static AtomicInteger buyersNumber = new AtomicInteger(1);     //нумератор покупателей
    static AtomicInteger buyersCount = new AtomicInteger(0);     //количество покупателей в магазине (в данный момент)
    static AtomicInteger buyersComplete = new AtomicInteger(0);
    static AtomicInteger overallPrice = new AtomicInteger(0);
    private static final int planCustomersCount = 100;     //план работы магазина
    static Semaphore semaphore = new Semaphore(0);
    static Semaphore semaphoreBuyers = new Semaphore(20);
    static Semaphore semaphoreBaskets = new Semaphore(50);
    static Semaphore semaphoreConsole = new Semaphore(1);



    static boolean planComplete() {
        return buyersComplete.get() == planCustomersCount;
    }


    static boolean marketIsClosed() {
        return buyersCount.get() + buyersComplete.get() >= planCustomersCount;

    }
}
