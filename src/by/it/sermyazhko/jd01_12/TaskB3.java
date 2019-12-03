package by.it.sermyazhko.jd01_12;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            list.add(Double.toString(Math.random()*10+1));
        }
        long start = System.nanoTime();
        process((ArrayList<String>) list);
        long end = System.nanoTime();
        long del = end - start;
        System.out.println("Время работы для  ArrayList=" + del);


        LinkedList<String> list1 = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            list1.add(Double.toString(Math.random()*10+1));
        }
        long start1 = System.nanoTime();
        process((LinkedList<String>) list1);
        long end1 = System.nanoTime();
        long del1 = end1 - start1;
        System.out.println("Время работы для LinkedList=" + del1);
    }


    static String process(ArrayList<String> peoples) {
        //long start = System.nanoTime();
        List<String> list = new ArrayList<>(peoples);
        int count = 0;
        Iterator<String> iterator = list.iterator();
        while(list.size() > 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;
                }
            }
            else {
                iterator = list.iterator();
            }
        }
        for (String people : list) {
            /*long end = System.nanoTime();
            long del = end - start;
            System.out.println(del);*/
            return people;
        }
        return null;
    }



    static String process(LinkedList<String> peoples) {
        //long start = System.nanoTime();
        List<String> list = new LinkedList<>(peoples);
        int count = 0;
        Iterator<String> iterator = list.iterator();
        while(list.size() > 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;
                }
            }
            else {
                iterator = list.iterator();
            }
        }
        for (String people : list) {
           /* long end = System.nanoTime();
            long del = end - start;
            System.out.println(del);*/
            return people;
        }
        return null;
    }
}
