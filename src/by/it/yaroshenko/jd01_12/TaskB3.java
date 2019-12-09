package by.it.yaroshenko.jd01_12;

import java.util.*;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size()!=1) {
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
                iterator.next();
            } else {
                iterator.next();
            }
            if (!iterator.hasNext()) {
                iterator = peoples.iterator();
                iterator.next();
                iterator.remove();
            } else {
                iterator.next();
                iterator.remove();
            }
        }
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size()!=1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();

            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
        }
        return peoples.get(0);
    }

    public static class Timer {
        private long iniTime;
        Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            double delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "END " + delta + " us";
        }
    }

    public static void main(String[] args) {
        int size=4096;
        String [] arr =new String[size];
        for (int i = 0; i < size; i++) {
            int n=(int) (Math.ceil(Math.random()*11));
            arr[i]= String.valueOf(n);
        }

        Timer t1=new Timer();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(process(list));
        System.out.println(t1);
        Timer t2=new Timer();
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        System.out.println(process(linkedList));
        System.out.println(t2);
    }
}
