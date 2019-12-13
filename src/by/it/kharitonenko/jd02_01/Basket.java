package by.it.kharitonenko.jd02_01;

import by.it.kharitonenko.jd02_01.Utils.Goods;

import java.util.ArrayList;

//TODO finish design
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

    public void checkBasket() {
        for (Goods goods : basket) {
            System.out.print("[" + goods.getNAME() + "] ");
        }
        System.out.println();
    }
}
