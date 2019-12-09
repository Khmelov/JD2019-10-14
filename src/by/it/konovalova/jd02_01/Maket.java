package by.it.konovalova.jd02_01;

//    Напишите программу,моделирующую поток покупателей Buyer в магазине
//    Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
//    Каждый покупатель реализует интерфейс IBuyer
//    public interface IBuyer {
//    void enterToMarket(); //вошел в магазин (мгновенно)
//    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
//    void goOut(); //отправился на выход(мгновенно)


import java.util.ArrayList;
import java.util.List;

public class Maket {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < 120; i++) {
            int currentCount = Helper.random(2);
            for (int j = 0; j <= currentCount; j++) {
                Buyer buyer = new Buyer(++Dispatcher.counterBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            buyer.join();
        }
        System.out.println("Market closed");
    }
}
