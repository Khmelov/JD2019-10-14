package by.it.komarov.jd01_12;

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

        System.out.println("ArrayList: " + process(new ArrayList<>(Arrays.asList(peoples))));
        System.out.println("LinkedList: " + process(new LinkedList<>(Arrays.asList(peoples))));
    }

    private static void lapSore(List<String> peoples){
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
    }

    private static String process(ArrayList<String> peoples) {
        lapSore(peoples);
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
         lapSore(peoples);
         return peoples.get(0);
    }
}
