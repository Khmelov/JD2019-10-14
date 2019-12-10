package by.it.volchek.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB2 {
    static String process(ArrayList<String> peoples) {
        ListIterator<String> iterator = peoples.listIterator();
        int counter = 0;
        while (peoples.size() != 1) {
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            iterator.next();
            counter++;
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            if (counter == 1) {
                iterator.next();
                iterator.remove();
                counter = 0;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        ListIterator<String> iterator = peoples.listIterator();
        int counter = 0;
        while (peoples.size() != 1) {
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            iterator.next();
            counter++;
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            if (counter == 1) {
                iterator.next();
                iterator.remove();
                counter = 0;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {

    }
}
