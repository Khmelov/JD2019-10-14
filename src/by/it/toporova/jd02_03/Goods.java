package by.it.toporova.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {
    static Map<String, Integer> priceList = new HashMap<>(); //карта товаров

    static void loadPriceList() {//предопределенный список и цены на товар
        priceList.put("хлеб", 1);
        priceList.put("молоко", 1);
        priceList.put("кефир", 2);
        priceList.put("колбаса", 6);
        priceList.put("сыр", 4);
        priceList.put("мандарины", 3);
        priceList.put("чай", 4);
        priceList.put("батон", 1);
        priceList.put("килька", 4);
        priceList.put("яблоки", 2);
        priceList.put("яйца", 2);

    }

    int getPriceListSize() {
        return priceList.size();
    }

    //геттер цены товара из списка товаров магазина
    int getPrice(String goods)
    {
        return priceList.getOrDefault(goods, 0);
    }
}