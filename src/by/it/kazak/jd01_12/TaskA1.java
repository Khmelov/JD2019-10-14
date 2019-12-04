package by.it.kazak.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element < 4) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = 1 + (int) (Math.random() * 10);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }
}
