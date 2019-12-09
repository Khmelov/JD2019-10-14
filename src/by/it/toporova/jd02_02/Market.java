package by.it.toporova.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Market {

    //коллекция количеств покупателей в определённый момент времени в магазине (для вывода статистики в конце)
    private static LinkedList<Integer> numberOfBuyers = new LinkedList<>();

    private static LinkedList<Integer> enteredBuyers = new LinkedList<>();

    static List<Thread> listOfThreads = new ArrayList<>();    //коллекция всех запущенных потоков
    private static int number = 1;     //статическое поле для нумерации покупателей

    public static void main(String[] args) {
        workingMarket();
        marketStatistics();
    }

    //вывод статистики магазина по секундам (по запускам покупателей
    private static void marketStatistics() {
        System.out.println("Buyers in Market Statistics:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("entry №  | number of buyers in the market | entered buyers | total number of buyers (in the market + entered) |\n");
        for (int i = 1; i <= n; i++) {
            int n1, n2;
            Integer nu1 = numberOfBuyers.pollLast();
            Integer nu2 = enteredBuyers.pollLast();
            if (nu1 != null) n1 = nu1;
            else throw new NullPointerException();
            if (nu2 != null) n2 = nu2;
            else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%46d    |\n", i, nu1, nu2, n1 + n2);
        }
    }

    //метод "магазин в рабочем состоянии"
    private static void workingMarket() {
        int max_entries = 2;
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println("Market is open");
        }

        startOfFirstCashier();
        for (int i = 1; i <= 180; i++) {
            enteringBuyers(max_entries, i);
            if (!Dispatcher.marketIsOpen() || Dispatcher.planIsComplete()) break;
        }
        synchronized (Dispatcher.LOCK_ARRAY) {
            try {
                Dispatcher.LOCK_ARRAY.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : listOfThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println("Market is closed");
        }
    }

    //метод для открытия первой кассы
    private static void startOfFirstCashier() {
        Cashier c = new Cashier(Dispatcher.cashiersNumber++);
        Thread th = new Thread(c);
        listOfThreads.add(th);
        th.start();
    }

    //метод для запуска покупателей в магазин пилообразно
    private static void enteringBuyers(int max_entries, int i) {
        int sec = i % 60;
        int num = -1;
        if (sec < 30) {
            if (Dispatcher.getBuyersCount() < 10 + sec) {
                num = (sec + 10 - Dispatcher.getBuyersCount()) > max_entries ? max_entries :
                        (Helper.getRandom(sec + 10 - Dispatcher.getBuyersCount(), max_entries));
            }
        } else {
            if (Dispatcher.getBuyersCount() > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = Helper.getRandom(0, max_entries);
        numberOfBuyers.offerFirst(Dispatcher.getBuyersCount());
        enteredBuyers.offerFirst(num);
        for (int j = 0; j < num; j++) {
            if (Dispatcher.marketIsOpen()) {
                Buyer buyer = new Buyer(number++);
                listOfThreads.add(buyer);
                buyer.start();
            }
        }
        Helper.sleep(1000);
    }
}
