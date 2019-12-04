package by.it.bodukhin.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peoples = new String[4096];

        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = "n" + (i);
        }

        List<String> arr = Arrays.asList(peoples);
        ArrayList<String> arrayList = new ArrayList<>(arr);
        LinkedList<String> arrayLinkedList = new LinkedList<>(arr);

        long first = System.nanoTime();
        System.out.println("List: " + process(arrayList));
        long second = System.nanoTime();
        System.out.println("LinkedList: " + process(arrayLinkedList));
        long third = System.nanoTime();

        long resultList = second-first;
        System.out.println("Время работы List " + resultList);
        long resultLinkedList = third-second;
        System.out.println("Время работы LinkedList " + resultLinkedList);
        long diff = resultList-resultLinkedList;
        System.out.println(diff);

    }

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            iterator.remove();
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
            }
            iterator.next();
            iterator.remove();
        }

        return peoples.get(0);
    }
}
