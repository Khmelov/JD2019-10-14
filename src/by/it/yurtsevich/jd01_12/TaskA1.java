package by.it.yurtsevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> list=new ArrayList<>();
    private void clearBad(List<Integer> grades){
        grades.removeIf(grade -> grade < 4);
    }
    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 25 ; i++)
            task.list.add((int) Math.ceil(Math.random()*10));
        System.out.println(task.list);
        task.clearBad(task.list);
        System.out.println(task.list);
    }
    }

