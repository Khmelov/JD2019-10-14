package by.it.yurtsevich.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Valera");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(1));
    }
}