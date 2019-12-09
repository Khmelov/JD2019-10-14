package by.it.konovalova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades=new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = 1+(int) (Math.random()*10);
            task.grades.add(grade);
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4) iterator.remove();
        }
    }
}
