package by.it.zabauniuk.jd01_12;

import java.util.*;

public class TaskB2 {


    public static void main(String[] args) {
        System.out.println("Введите количество людей: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] peoples = new String[n];
        System.out.println("Введите имена людей по одному через Enter: ");
        scanner = new Scanner(System.in);
        for (int i = 0; i <n; i++) {
            String name = scanner.nextLine();
            peoples[i] = name;
        }


        List<String> arr = Arrays.asList(peoples);
        ArrayList<String> resArray= new ArrayList<>(arr);
        LinkedList<String> resLink = new LinkedList<>(arr);

        String resultArray = process(resArray);
        String resultLink = process(resLink);

        System.out.println("ArrayList " + resultArray);
        System.out.println("LinkedList " + resultLink);


    }


    private static String process(ArrayList<String> peoples){
        Iterator<String> it = peoples.iterator();
        while (peoples.size()!=1){
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            it.remove();
        }
        return peoples.get(0);
    }


    private static String process(LinkedList<String> peoples){
        Iterator<String> it = peoples.iterator();
        while (peoples.size()!=1) {
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            it.remove();
        }
        return peoples.get(0);
    }
}

