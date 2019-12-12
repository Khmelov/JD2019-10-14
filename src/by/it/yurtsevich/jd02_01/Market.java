package by.it.yurtsevich.jd02_01;

import java.util.*;

public class Market {

    private static Map<String, Double> goods = new HashMap<>(20);

    static Map.Entry<String, Double> takeGoods() {
        goods.put("Соль", 1.0);
        goods.put("Творог", 0.99);
        goods.put("Хлеб", 0.8);
        goods.put("Йогурт", 3.6);
        goods.put("Молоко", 2.0);
        goods.put("Курица", 8.6);
        goods.put("Капуста", 0.68);
        goods.put("Макароны", 2.9);
        goods.put("Картофель", 0.86);
        goods.put("Мука", 1.57);
        Set<Map.Entry<String, Double>> entries = goods.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        int number = Util.random(1, goods.size());
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            if (i == number)
                return iterator.next();
            else iterator.next();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("Магазин открыт");
        int numberBuyers = 0;
        List<Buyer> buyerList = new ArrayList<>(200);
        numberBuyers = generateBuyers(numberBuyers, buyerList);
        generateBuyers(numberBuyers, buyerList);
        for (Buyer b : buyerList)
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Магазин закрыт");
    }

    private static int generateBuyers(int numberBuyers, List<Buyer> buyerList) {
        int time;

        for (time = 1; time <= 60; time++) {
            System.out.println(time + " " + Dispacther.getBuyerInMarket());// проверка

            int countBuyers = Util.random(2);

            if (time <= 30 && Dispacther.getBuyerInMarket() <= time + 10) {
                for (int i = 0; i <= countBuyers; i++) {
                    Buyer buyer = new Buyer(++numberBuyers);

                    if (numberBuyers % 4 == 0) {
                        buyer.setPensioneer();
                    }
                    buyerList.add(buyer);
                    buyer.start();
                }
            } else if (time > 30 && Dispacther.getBuyerInMarket() <= 40 + 30 - time) {
                for (int i = 0; i <= countBuyers; i++) {
                    Buyer buyer = new Buyer(++numberBuyers);

                    if (numberBuyers % 4 == 0) {
                        buyer.setPensioneer();
                    }
                    buyerList.add(buyer);
                    buyer.start();
                }
            }


            Util.sleep(1000);

        }


        return numberBuyers;
    }
}