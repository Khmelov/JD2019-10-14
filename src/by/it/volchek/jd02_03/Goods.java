package by.it.volchek.jd02_03;

import java.util.HashMap;

public class Goods {

    static HashMap <String, Integer> list = new HashMap<>();

    static {
        list.put("cheese", 2);
        list.put("milk", 1);
        list.put("bread", 1);
        list.put("water", 1);
        list.put("mayo", 2);
        list.put("vodka", 7);
        list.put("ham", 3);
        list.put("chicken", 6);
        list.put("cola", 2);
    }

}
