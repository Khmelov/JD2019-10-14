package by.it.komarov.jd02_01;

import java.util.*;

public class Backet {
    static final Map<String, Double> goodsList= new HashMap<String, Double>(){{
        put("potato", 0.69);
        put("tomato", 0.80);
        put("chips", 2.30);
        put("bacon", 6.99);
        put("milk", 1.69);
        put("cheese", 4.59);
        put("meat", 8.20);
        put("fish", 12.50);
        put("bread", 1.67);
        put("water", 2.01);
        put("cola", 1.54);
        put("sold", 0.65);
    }};

    static Map<String, Double> chooseList (){
        List<String> keys = new ArrayList<>(goodsList.keySet());
        String randomKey = keys.get((int) (Math.random() * (keys.size())));
        Map<String, Double> backet = new HashMap<>();
        backet.put(randomKey, goodsList.get(randomKey));
        return backet;
    }
}
