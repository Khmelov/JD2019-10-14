package by.it.toporova.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Double> priceList = new HashMap<>(); //карта товаров

    static void loadPriceList() {//предопределенный список и цены на товар
        priceList.put("хлеб", 0.9);
        priceList.put("молоко", 1.3);
        priceList.put("кефир", 1.5);
        priceList.put("колбаса", 6.2);
        priceList.put("сыр", 4.1);
        priceList.put("мандарины", 2.3);
        priceList.put("чай", 3.6);
        priceList.put("батон", 0.9);
        priceList.put("килька", 4.2);
        priceList.put("яблоки", 2.0);
        priceList.put("яйца", 2.4);

    }
}
