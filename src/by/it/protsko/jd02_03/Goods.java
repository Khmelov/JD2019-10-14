package by.it.protsko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Goods {
    private static Map<String, Double> goodsList = new HashMap<>();

    static {
        goodsList.put("milk", 2.15);
        goodsList.put("bread", 1.75);
        goodsList.put("lemon", 4.30);
        goodsList.put("meat", 9.60);
        goodsList.put("apple", 3.35);
        goodsList.put("rice", 2.50);
        goodsList.put("potatoes", 1.75);
        goodsList.put("tea", 8.10);
    }

    static Map<String, Double> randomGood() {
        Map<String, Double> choosingGood = new HashMap<>();
        List<String> keys = new ArrayList<>(goodsList.keySet());
        String randomKey = keys.get((int) (Math.random() * (keys.size())));
        choosingGood.put(randomKey, goodsList.get(randomKey));
        return choosingGood;
    }
}
