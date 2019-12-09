package by.it.toporova.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Market {

    private static Deque<Integer> numberOfBuyers = new LinkedList<>();    //для статистики
    private static Deque<Integer> enteredBuyers = new LinkedList<>();     //для статистики
    private static Deque<Integer> queueSize = new LinkedList<>();         //для статистики
    private static Deque<Integer> cashiersCount = new LinkedList<>();     //для статистики


    public static void main(String[] args) {
        try {
            Dispatcher.semaphoreConsole.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market is open");
        Dispatcher.semaphoreConsole.release();
        ExecutorService cashiers = Executors.newFixedThreadPool(5);
        ExecutorService buyers = Executors.newFixedThreadPool(100);
        cashiers.execute(new Cashier(Dispatcher.cashiersNumber.getAndIncrement()));

        for (int i = 0; i < 300; i++) {
            if (Dispatcher.planComplete()) break;
            workingMarket(cashiers, buyers, i);
            Helper.sleep(1000);
        }

        buyers.shutdown();
        cashiers.shutdown();
        while (!buyers.isTerminated()) Helper.sleep(1);
        while (!cashiers.isTerminated()) Thread.yield();
        try {
            Dispatcher.semaphoreConsole.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market is closed");
        Dispatcher.semaphoreConsole.release();
        marketStatistics();      //вывод статистики
    }

    private static void workingMarket(ExecutorService cashiers, ExecutorService buyers, int i) {
        numberOfBuyers.offerFirst(Dispatcher.buyersCount.get());   //для статистики
        cashiersCount.offerFirst(Dispatcher.cashiersCount.get());   //для статистики
        queueSize.offerFirst(BuyerQueue.queue.size());             //для статистики
        int num = Dispatcher.marketIsClosed() ? 0 : getNum(i);      //количество запускаемых покупателей
        enteredBuyers.offerFirst(num);        // статистика
        for (int j = 0; j < num; j++) {       //запускаем покупателей
            if (Dispatcher.marketIsClosed()) break;
            buyers.execute(new Buyer(Dispatcher.buyersNumber.getAndIncrement()));
        }
        if (BuyerQueue.queue.size() > Dispatcher.cashiersCount.get() * 5 &&   //если нехватает открываем кассы. Тут недописано!!!!
                Dispatcher.cashiersCount.get() < 5)
            cashiers.execute(new Cashier(Dispatcher.cashiersNumber.getAndIncrement()));
    }

    private static int getNum(int i) {
        int sec = i % 60;
        int num = -1;
        if (sec < 30) {
            if (Dispatcher.buyersCount.get() < 10 + sec) {
                num = (sec + 10 - Dispatcher.buyersCount.get()) > 2 ? 2 :
                        (Helper.getRandom(sec + 10 - Dispatcher.buyersCount.get(), 2));
            }
        } else {
            if (Dispatcher.buyersCount.get() > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = Helper.getRandom(0, 2);
        return num;
    }

    private static void marketStatistics() {
        System.out.println("Buyers in Market Statistics:");
        System.out.println("------------------------------------------------------------------" +
                "----------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("entry №  | number of buyers in the market | entered buyers |" +
                " total number of buyers (in the market + entered) | cashier's count | queue size |\n");
        for (int num = 1; num <= n; num++) {
            int n1, n2;
            Integer num1 = numberOfBuyers.pollLast();
            Integer num2 = enteredBuyers.pollLast();
            Integer num3 = queueSize.pollLast();
            Integer num4 = cashiersCount.pollLast();
            Integer totalSum =0;//TODO итоговую суммы выручки
            if (num1 != null) n1 = num1;
            else throw new NullPointerException();
            if (num2 != null) n2 = num2;
            else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%46d    |%6d      |%10d       |\n",
                    num, num1, num2, n1 + n2, num4, num3);
        }
    }
}