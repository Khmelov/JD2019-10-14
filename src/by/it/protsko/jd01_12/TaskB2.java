package by.it.protsko.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peoplesAl = new ArrayList<>();
        LinkedList<String> peoplesLl = new LinkedList<>();

        fillTheList(peoplesAl);
        fillTheList(peoplesLl);

        System.out.println("Result for ArrayList: " + process(peoplesAl));
        System.out.println("Result for LinkedList: " + process(peoplesLl));
    }

    private static String process(ArrayList<String> peoples) {
        commonProcess(peoples);
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        commonProcess(peoples);
        return peoples.get(0);
    }

    private static void commonProcess(List<String> list) {
        while (list.size() > 1) {
            ListIterator<?> iterator = list.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                } else {
                    iterator = list.listIterator();
                    iterator.next();
                    iterator.remove();
                    break;
                }
            }
        }
    }

    private static void fillTheList (List<String> people) {
        for (int count = 1; count <= 12; count++) {
            people.add(String.valueOf(count));
        }
    }
}