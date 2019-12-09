package by.it.protsko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TaskA1 {
    private List<Integer> grades = new ArrayList<>();
//    private void clearBad(List<Integer> grades) {                                         //вариант 2 (не забывать про лямбду!!!!)
//        grades.removeIf(integer -> integer < 4);
//    }

    private void clearBad(List<Integer> grades) {                                          //вариант 1
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 object = new TaskA1();
        for (int count = 0; count < 15; count++) {
            object.grades.add(1 + (int) (Math.random() * 10));
        }

        System.out.print("Оценки до вызова метода void clearBad: ");
        for (Integer grade : object.grades) {
            System.out.print(grade + " ");
        }

        object.clearBad(object.grades);
        System.out.println();
        System.out.print("Оценки после вызова метода void clearBad: ");
        for (Integer grade : object.grades) {
            System.out.print(grade + " ");
        }
    }
}
