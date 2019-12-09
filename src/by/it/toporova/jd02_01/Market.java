package by.it.toporova.jd02_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//класс-страртер, описывающий поведение магазина
public class Market {
    private static LinkedList<Integer> numberOfBuyers = new LinkedList<>();//считаем  покупателей
    private static LinkedList<Integer> enteredBuyers = new LinkedList<>();
    private static List<Buyer> listOfBuyers = new ArrayList<>();
    private static int number = 1; //стартуем с покупателя номер 1

    public static void main(String[] args) {
        Goods.loadPriceList();
        workingMarket();
        marketStatistics();
    }

    private static void marketStatistics() {
        System.out.println("/--------------Statistics--------------/");
        System.out.printf("/-----Total buyers: %d, retired buyers: %d/\n", Dispatcher.totalBuyersCount, Dispatcher.totalRetiredCount);
        System.out.println("-------------------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("       № | number of buyers in the market | entered buyers |     total number of buyers       |\n");
        for (int i = 1; i <= n; i++) {
            int n1, n2;
            Integer last1 = numberOfBuyers.pollLast();
            Integer last2 = enteredBuyers.pollLast();
            if (last1 != null) n1 = last1;
            else throw new NullPointerException();
            if (last2 != null) n2 = last2;
            else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%30d    |\n", i, last1, last2, n1 + n2);
        }
    }

    private static void workingMarket() {
        // int max_entries = 8;
        Helper.getRandom(0, 2); //входит от 0 до 2 покупателей в секунду в течение 2 минут
        System.out.println("Market is open");
        int entries = Helper.getRandom(0, 2);
        for (int i = 1; i < 120; i++) {
            for (int i1 = 1; i1 <= entries; i1++) {
                enteringBuyers(entries, i);
            }
        }
        for (Buyer buyer : listOfBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }

    private static void enteringBuyers(int max_entries, int i) {
        int sec = i % 60;
        int num = -1;
        if (sec <= 30) {
            if (Dispatcher.buyersCount < 10 + sec) {
                num = (sec + 10 - Dispatcher.buyersCount) > max_entries ? max_entries :
                        (Helper.getRandom(sec + 10 - Dispatcher.buyersCount, max_entries));
            }
        } else {
            if (Dispatcher.buyersCount > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = Helper.getRandom(0, max_entries);
        numberOfBuyers.offerFirst(Dispatcher.buyersCount);
        enteredBuyers.offerFirst(num);
        for (int j = 0; j < num; j++) {
            Buyer buyer = new Buyer(number++);
            listOfBuyers.add(buyer);
            buyer.start();
        }
        Helper.sleep(1000);
    }
}