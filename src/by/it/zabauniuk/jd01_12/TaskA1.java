package by.it.zabauniuk.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> list = new ArrayList<>();

    private void clearBad(List<Integer> grades){//grades.iterator().var....
        grades.removeIf(grade -> grade < 4);
    }
    public static void main(String[] args) {
        TaskA1 task = new TaskA1();//экземпляр задачи такс А1
        for (int i = 0; i < 20; i++) {
            task.list.add(1 + (int) (Math.random() * 10));
        }
        System.out.println(task.list);
        task.clearBad(task.list);
    }

}
