package by.it.kazak.jd01_12;

import java.util.*;

public class TaskB3 {

        public static void main(String[] args) {
        List<String> base = new ArrayList<>();
            for (int i = 0; i < 1024; i++) {
                base.add("1");
                base.add("2");
                base.add("3");
                base.add("4");
            }
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> stringLinkedList = new LinkedList<>(base);
        String ppl1 = TaskB3.process(arrayList);
        String ppl2 = TaskB3.process(stringLinkedList);
        System.out.println(ppl1);
        System.out.println(ppl2);
    }

    private static String process(ArrayList<String> arrayList){
            Timer t = new Timer();
        Iterator<String> iterator = arrayList.iterator();
        while (arrayList.size() !=1) {
            if (!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            iterator.remove();
        }
        System.out.println(t+" работы ArrayList");
        return arrayList.get(0);
    }

    private static String process(LinkedList<String> stringLinkedList) {
            Timer t1 = new Timer();
        Iterator<String> iterator = stringLinkedList.iterator();
        while (stringLinkedList.size() != 1) {
            if (!iterator.hasNext())
                iterator = stringLinkedList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = stringLinkedList.iterator();
            iterator.next();
            iterator.remove();
        }
        System.out.println(t1+" работы LinkedList");
        return stringLinkedList.get(0);
    }
    public static class Timer{
            private long iniTime;
            private Double Delta;
            Timer() {iniTime = System.nanoTime(); };
            public String toString() {
                Delta = (double)(System.nanoTime() - iniTime) / 1000;
                iniTime = System.nanoTime();
                return "Прошло "+Delta.toString()+" микросекунд";
            }
    }

}
