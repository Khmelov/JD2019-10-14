package by.it.volchek.jd01_12;

import java.util.*;

public class TaskB3 {
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
        Deque<String> peopleDeque = peoples;
        while (peopleDeque.size() != 1) {
            peopleDeque.addLast(peopleDeque.remove());
            peopleDeque.remove();
        }
        return peopleDeque.peek();
    }

    private static String[] arrayPeople(int numberOfPeople) {
        String[] result = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            result[i] = String.valueOf((int) (Math.random() * 100));
        }
        return result;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        String[] people = arrayPeople(4096);
        System.out.println("Массив из " + people.length + " элементов готов. \n" + timer);
        ArrayList<String> arrayPeople = new ArrayList<>(Arrays.asList(people));
        System.out.println("ArrayList готов. \n" + timer);
        LinkedList<String> linkedPeople = new LinkedList<>(Arrays.asList(people));
        System.out.println("LinkedList готов. \n" + timer);
        System.out.println(process(arrayPeople));
        System.out.println("ArrayList метод завершен. \n" + timer);
        System.out.println(process(linkedPeople));
        System.out.println("LinkedList метод завершен. \n" + timer);
    }
}
