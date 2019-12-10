package by.it.komarov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListB<>();
        List<String> arList = new ArrayList<>();

        HashMap<Integer, String> m = new HashMap<>();
        m.put(5, "a");
        m.put(4, "b");
        m.put(3, "c");
        m.put(2, "d");
        m.put(1, "e");
        System.out.println(m);

        LinkedHashMap<Integer, String> m1 = new LinkedHashMap<>();
        m1.put(5, "a");
        m1.put(4, "b");
        m1.put(3, "c");
        m1.put(2, "d");
        m1.put(1, "e");
        System.out.println(m1);

        myList.add("First"); arList.add("First");
        myList.add("Second"); arList.add("Second");
        myList.add("Third"); arList.add("Third");
        System.out.println("myList:" + myList + "\narList:" + arList);

        myList.add(2, "Tree"); arList.add(2, "Tree");
        myList.add(0, "Start"); arList.add(0, "Start");
        System.out.println("myList:" + myList + "\narList:" + arList);

        myList.remove("Start"); arList.remove("Start");
        myList.remove(3); arList.remove(3);

        myList.set(2, "SEeeeeeet"); arList.set(2, "SEeeeeeet");
        System.out.println("myList:" + myList + "\narList:" + arList);

        System.out.println(myList.isEmpty());
        System.out.println(myList.size());
        System.out.println(myList.contains("Second"));

        System.out.println("myList:" + myList.get(0) + "\narList:" + arList.get(0));
    }
}
