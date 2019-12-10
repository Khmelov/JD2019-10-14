package by.it.konovalova.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {

        ArrayList<String> people = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            people.add(Double.toString(Math.random()*25));
        }
        long startArray = System.nanoTime();
        long finishArray = System.nanoTime();
        process(people);
        System.out.println("Время работы ArrayList=" + (finishArray - startArray));

        LinkedList<String> peopleNew = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            peopleNew.add(Double.toString(Math.random()*25));
        }
        long startLinked = System.nanoTime();
        long finishLinked = System.nanoTime();
        process(peopleNew);
        System.out.println("Время работы LinkedList=" + (finishLinked - startLinked));

    }

    private static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int count = 0;
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == 2) {
                    iterator.remove();
                    count = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        return peoples.iterator().next();
    }

    private static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int count = 0;
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == 2) {
                    iterator.remove();
                    count = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        return peoples.iterator().next();
    }
}




