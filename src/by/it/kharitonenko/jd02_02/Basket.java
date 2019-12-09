package by.it.kharitonenko.jd02_02;

import by.it.kharitonenko.jd02_02.Utils.Goods;

import java.util.ArrayList;

public class Basket {
    private int capacity; //number of goods that can be stored
    private ArrayList<Goods> basket; //list of goods inside the customer's basket

    public Basket() {
        capacity = 4;
        basket = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int buySomething(Goods boughtItem, int availableMoney) {
        if (boughtItem.getPRICE() < availableMoney) {
            basket.add(boughtItem);
            capacity--;
            return boughtItem.getPRICE();
        }
        return -1;
    }

    public String checkBasket() {
        StringBuilder basketInside = new StringBuilder();
        for (Goods goods : basket) {
            basketInside.append("[" + goods.getNAME() + " $" + goods.getPRICE() + "] ");
        }
        return basketInside.toString();
    }
}
