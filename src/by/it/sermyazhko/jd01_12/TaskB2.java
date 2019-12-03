package by.it.sermyazhko.jd01_12;


import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       // list.addAll(Arrays.asList("Dasha,Vasia,Petia,Roman,Balia,Sergy,Volodia"));
        list.addAll(Arrays.asList(new String[]{"1","2","3", null}));
        process((ArrayList<String>) list);
        List<String> list1 = new LinkedList<>();
        list1.addAll((Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", null})));
        process((LinkedList<String>) list1);
    }

    static String process(ArrayList<String> peoples) {
        List<String> list = new ArrayList<>(peoples);
        int count = 0;
        Iterator<String> iterator = list.iterator();
        while(list.size() > 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;
                }
            }
            else {
                iterator = list.iterator();
            }
        }
        for (String people : list) {
            System.out.println(people);
            return people;
        }
        return null;
    }

    static String process(LinkedList<String> peoples) {
       List<String> list = new LinkedList<>(peoples);
        int count = 0;
        Iterator<String> iterator = list.iterator();
        while(list.size() > 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;
                }
            }
            else {
                iterator = list.iterator();
            }
        }
        for (String people : list) {
            System.out.println(people);
            return people;
        }
        return null;
    }
}
