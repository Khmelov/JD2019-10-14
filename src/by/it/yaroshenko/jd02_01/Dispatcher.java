package by.it.yaroshenko.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    static int buyerCount=0;
    static int kspeed=1;

   static Map<String, String> mapGoods = new HashMap<>();

    public static void setGoods() {
        mapGoods.put("Milk", "2");
        mapGoods.put("Bread", "1");
        mapGoods.put("Wine", "22");
        mapGoods.put("Nuts", "4");
        mapGoods.put("Orange", "1");
        mapGoods.put("Cokao", "3");
        mapGoods.put("Mango", "2");
        mapGoods.put("PineApple", "4");
        mapGoods.put("Oil", "3");
        mapGoods.put("Water", "0.5");
        mapGoods.put("Beer", "1.5");
        mapGoods.put("Chokolate", "0.7");
        mapGoods.put("Icecream", "1");
        mapGoods.put("Coca-cola", "1");
        mapGoods.put("Sprite", "1");
        mapGoods.put("Beef", "5");
    }

    public static Map<String, String> getMapGoods() {
        return mapGoods;
    }
}
