package by.it.zimina.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Water",2.0));
        goods.put(2, new Good("Salt",0.5));
        goods.put(3, new Good("Pizza", 7.0));
        goods.put(4, new Good("IceCream", 3.6));
    }

    static Good getRandomGood() {
        int id = 1 + (int) (Math.random()*4);
        return goods.get(id);
    }
}
