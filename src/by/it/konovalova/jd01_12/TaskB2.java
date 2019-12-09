package by.it.konovalova.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {
        String[] men = {"Ivan", "Sergey", "Dmitry", "Petr", "Oleg"};
        ArrayList<String> people = new ArrayList<>(Arrays.asList(men));
        LinkedList<String> peopleNew = new LinkedList<>(Arrays.asList(men));
        System.out.println(process(people));
        System.out.println(process(peopleNew));
    }

    private static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int count=0;
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
        int count=0;
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
