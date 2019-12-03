package by.it.bodukhin.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        System.out.println("Введите количество человек");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] peoples = new String[size];
        System.out.println("Введите имена людей через пробел");

        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = scanner.next();
        }

        List<String> arr = Arrays.asList(peoples);
        ArrayList<String> arrayList = new ArrayList<>(arr);
        LinkedList<String> arrayLinkedList = new LinkedList<>(arr);

        System.out.println("List: " + process(arrayList));
        System.out.println("LinkedList: " + process(arrayLinkedList));

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