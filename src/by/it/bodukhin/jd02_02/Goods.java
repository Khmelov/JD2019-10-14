package by.it.bodukhin.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Bread",2.0));
        goods.put(2, new Good("Milk",1.5));
        goods.put(3, new Good("Vodka", 7.1));
        goods.put(4, new Good("Beer", 2.6));
    }

    static Good getRandomGood() {
        int id = 1 + (int) (Math.random()*4);
        return goods.get(id);
    }
}
