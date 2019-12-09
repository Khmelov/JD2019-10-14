package by.it.komarov.jd01_12;

import java.util.*;

class TaskB3 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        String[] people = createArrayByNumber(4096);
        System.out.println("Массив из " + people.length + " элементов готов. \n" + timer);
        System.out.println("ArrayList готов. \n" + timer);
        System.out.println("LinkedList готов. \n" + timer);
        System.out.println(process(new ArrayList<>(Arrays.asList(people))));
        System.out.println("ArrayList завершен. \n" + timer);
        System.out.println(process(new LinkedList<>(Arrays.asList(people))));
        System.out.println("LinkedList завершен. \n" + timer);
    }

    private static String process(ArrayList<String> peoples) {
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

    private static String process(LinkedList<String> peoples) {
        Deque<String> peopleDeque = peoples;
        while (peopleDeque.size() != 1) {
            peopleDeque.addLast(peopleDeque.remove());
            peopleDeque.remove();
        }
        return peopleDeque.peek();
    }

    private static String[] createArrayByNumber(int numberOfPeople) {
        String[] result = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            result[i] = String.valueOf((int) (Math.random() * 100));
        }
        return result;
    }


}
