package by.it.kazak.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        String[] array = {"1","2","3","4","5","6","7","8","9","10"};
        List<String> base = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> stringLinkedList = new LinkedList<>(base);
        String ppl1 = TaskB2.process(arrayList);
        String ppl2 = TaskB2.process(stringLinkedList);
        System.out.println(ppl1);
        System.out.println(ppl2);
    }

    private static String process(ArrayList<String> arrayList){
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
        return arrayList.get(0);
    }

    private static String process(LinkedList<String> stringLinkedList) {
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
        return stringLinkedList.get(0);
    }
}
