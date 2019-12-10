package by.it.protsko.jd01_11;

import java.util.ArrayList;
import java.util.List;

class Runner {

    public static void main(String[] args) {

        List<Integer> javaList = new ArrayList<>();
        ListA<Integer> listA = new ListA<>();


        javaList.add(10);   listA.add(10);
        javaList.add(20);   listA.add(20);
        javaList.add(30);   listA.add(30);
        javaList.add(40);   listA.add(40);
        javaList.add(50);   listA.add(50);
        javaList.add(40);   listA.add(40);
        javaList.add(40);   listA.add(40);
        javaList.add(50);   listA.add(50);

        System.out.println("JAVA: " +javaList);
        System.out.println("LIST: " +listA);

        javaList.add(2,25);   listA.add(2,25);
        javaList.add(4,45);   listA.add(4,45);

        System.out.println("JAVA: " +javaList);
        System.out.println("LIST: " +listA);

        javaList.remove(2);   listA.remove(2);
        javaList.remove(2);   listA.remove(2);

        System.out.println("JAVA: " +javaList);
        System.out.println("LIST: " +listA);

        javaList.remove((Object) 50);   listA.remove((Object) 50);

        System.out.println("JAVA: " +javaList);
        System.out.println("LIST: " +listA);

        System.out.println("JAVA: " +javaList.get(3));
        System.out.println("LIST: " +listA.get(3));

        System.out.println("JAVA: " +javaList.size());
        System.out.println("LIST: " +listA.size());

        System.out.println("JAVA: " +javaList.isEmpty());
        System.out.println("LIST: " +listA.isEmpty());

        System.out.println("JAVA: " +javaList.contains((Object)20));
        System.out.println("LIST: " +listA.contains((Object)20));

        System.out.println("JAVA: " +javaList.contains((Object)20));
        System.out.println("LIST: " +listA.contains((Object)20));

        javaList.set(1, 100);   listA.set(1,100);

        System.out.println("JAVA: " +javaList);
        System.out.println("LIST: " +listA);

        System.out.println("JAVA: " +javaList.lastIndexOf((Object)40));
        System.out.println("LIST: " +listA.lastIndexOf((Object)40));

        javaList.addAll(javaList);   listA.addAll(listA);

        System.out.println("JAVA: " +javaList + javaList.size());
        System.out.println("LIST: " +listA + listA.size());

        javaList.clear();      listA.clear();

        System.out.println("JAVA: " +javaList + javaList.size());
        System.out.println("LIST: " +listA + listA.size());

    }
}
