package by.it.sermyazhko.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Integer> products = new HashMap<String, Integer>(){
        {
            for (int i = 100; i > 1; i--) {
                this.put(String.format("GOODS%d", i), i * Helper.random(28, 98) + 17);
            }
        }
    };

    /*
    public static void setProducts() {
        for (int i = 100; i > 1; i--) {
            products.put(String.format("GOODS%d", i), i * Helper.random(28, 98) + 17);
        }
    }*/
}
