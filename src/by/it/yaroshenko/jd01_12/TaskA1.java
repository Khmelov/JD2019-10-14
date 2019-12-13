package by.it.yaroshenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(next<4) {
                iterator.remove();
            }
        }
    }
    public static void main(String[] args) {
        TaskA1 taskA = new TaskA1();
        ArrayList<Integer> arrayList = taskA.arrayList;
        for (int i = 0; i < 10; i++) {
            arrayList.add((int) (Math.ceil(Math.random()*10)));
        }
        System.out.println(arrayList);
       taskA.clearBad(arrayList);
        System.out.println(arrayList);
    }
}
