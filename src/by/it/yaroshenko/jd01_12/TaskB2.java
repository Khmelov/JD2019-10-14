package by.it.yaroshenko.jd01_12;

import java.util.*;

public class TaskB2 {

//    private static ArrayList<String> list = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
//    private static LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size()!=1) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
                iterator.next();
            } else {
                iterator.next();
           }
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
                iterator.next();
                iterator.remove();
           } else {
                iterator.next();
               iterator.remove();
            }
        }
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size()!=1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();

            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
        }
        return peoples.get(0);
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        System.out.println(process(list));
        System.out.println(process(linkedList));
    }
}

