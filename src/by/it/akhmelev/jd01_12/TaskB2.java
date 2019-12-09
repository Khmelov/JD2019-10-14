package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {


    static String process(ArrayList<String> peoples) {
        ArrayList<String> list = new ArrayList<>(peoples);
        while (list.size() > 1) {
            String first = list.remove(0);
            String second= list.remove(0);
            list.add(first);
        }
        return list.get(0);

    }

    static String process(LinkedList<String> peoples) {
        LinkedList<String> l = new LinkedList<>(peoples);
        while (l.size() > 1) {
            l.addLast(l.pollFirst());
            l.pollFirst();
        }
        return l.poll();

    }

}
